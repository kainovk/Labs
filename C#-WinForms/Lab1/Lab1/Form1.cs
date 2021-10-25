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
    public partial class Form1 : Form
    {
        List<IPerson> personList = new List<IPerson>();

        public void updateAndPrintList()
        {
            listBox.Items.Clear();
            foreach (var el in personList)
            {
                String blank = el.Name + " - " + el.calcAge(DateTime.Now).ToString();
                listBox.Items.Add(blank);
            }
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void btn_del_Click(object sender, EventArgs e)
        {
            if (listBox.SelectedIndex != -1)
            {
                var result = MessageBox.Show("Подтвердить?", "Подтвердите действие", MessageBoxButtons.OKCancel);
                if (result == DialogResult.OK && listBox.SelectedIndex != -1)
                {
                    personList.RemoveAt(listBox.SelectedIndex);
                }
                updateAndPrintList();
            }
        }

        // если до того, как создавать человека, мы создали пользователя1 с именем Иван и пользователя2 с именем Петр,
        // то при открытии формы нам предложит имя Сергей 
        private void btn_create_Click(object sender, EventArgs e)
        {
            Form2 requestCreate;
            if (task1("Иван", "Петр"))
            {
                requestCreate = new Form2("Сергей");
            }
            else
            {
                requestCreate = new Form2();
            }

            if (requestCreate.ShowDialog() == DialogResult.OK)
            {
                IPerson person = requestCreate.getPerson();
                if (person.calcAge(DateTime.Now) != -1)
                {
                    personList.Add(person);
                }
                else
                {
                    MessageBox.Show("Incorrect birthday format!");
                }

            }
            updateAndPrintList();

            requestCreate.Dispose();
        }

        private void btn_change_Click(object sender, EventArgs e)
        {
            if (listBox.SelectedIndex != -1)
            {
                int index = listBox.SelectedIndex;
                Person personToChange = (Person)personList[index];

                Form2 requestChange = new Form2(personToChange);

                if (requestChange.ShowDialog() == DialogResult.OK && listBox.SelectedIndex != -1)
                {
                    IPerson person = requestChange.getPerson();
                }
                updateAndPrintList();

                requestChange.Dispose();
            }
        }

        private void listBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private bool task1(string s1, string s2)
        {
            
            if (personList.Count >= 2 && 
                personList[personList.Count - 2].Name == s1 && 
                personList[personList.Count - 1].Name == s2)
            {
                return true;
            }

            return false;
        }
    }
}
