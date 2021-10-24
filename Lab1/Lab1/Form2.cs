using Lab111;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab1
{
    public partial class Form2 : Form
    {
        Person newPerson = null;

        public Form2()
        {
            InitializeComponent();
        }

        public Form2(string name)
        {
            InitializeComponent();
            this.textBox_Name.Text = name;
        }

        public Form2(IPerson person) : this()
        {
            newPerson = (Person)person;
        }

        private void btn_accept_Click(object sender, EventArgs e)
        {
            if (newPerson != null) // change
            {
                newPerson.Name = textBox_Name.Text;
                this.DialogResult = DialogResult.OK;
            }
            else // create
            {
                String name = textBox_Name.Text;
                String cardnum = "";
                cardnum = textBox_CardNum.Text.ToString();

                if (textBox_CardNum.Text.Length == textBox_CardNum.MaxLength)
                {
                    newPerson = new Person(dateTimePicker1.Value);
                    newPerson.Name = name;
                    try
                    {
                        newPerson.CardNumber = Convert.ToInt32(cardnum);
                        this.DialogResult = DialogResult.OK;
                    }
                    catch (FormatException)
                    {
                        MessageBox.Show("Incorrect format!");
                        this.DialogResult = DialogResult.Cancel;
                    }
                    

                    
                }
                else
                {
                    MessageBox.Show("Номер должен состоять из 5 цифр!");
                    textBox_CardNum.Text = "";
                }
            }

            Close();
        }

        public IPerson getPerson()
        {
            return newPerson;
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            this.KeyPreview = true;

            if (newPerson != null)
            {
                textBox_Name.Text = newPerson.Name;
                dateTimePicker1.Value = newPerson.Bithday;
                textBox_CardNum.Text = newPerson.CardNumber.ToString();

                dateTimePicker1.Enabled = false;
                textBox_CardNum.Enabled = false;
            }
        }

        private void Form2_KeyDown(object sender, KeyEventArgs e)
        {

            if (newPerson != null &&
               e.KeyCode == Keys.L &&
               e.Control && e.Shift)
            {
                Auth loginForm = new Auth(this, dateTimePicker1, textBox_CardNum);
                loginForm.Show();

            }
        }

        private void btn_accept_MouseMove(object sender, System.Windows.Forms.MouseEventArgs e)
        {
            if (BackColor == Color.Orange && newPerson.CardNumber.ToString() != textBox_CardNum.Text)
            {
                btn_accept.Top -= e.Y;
                btn_accept.Left += e.X;
                if (btn_accept.Top < -10 || btn_accept.Top > 100)
                    btn_accept.Top = 60;
                if (btn_accept.Left < -80 || btn_accept.Left > 250)
                    btn_accept.Left = 120;
            }
        }

        private void btn_decline_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
