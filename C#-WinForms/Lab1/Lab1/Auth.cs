using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Security.Cryptography;
using System.IO;

namespace Lab111
{
    public partial class Auth : Form
    {
        public Form form;
        public DateTimePicker dp;
        public TextBox tb;


        public Auth(Form form, DateTimePicker dp, TextBox tb) : this()
        {
            this.form = form;
            this.dp = dp;
            this.tb = tb;

        }

        public Auth()
        {
            InitializeComponent();
            string[] installs = new string[] { "user", "admin" };
            comboBox.Items.AddRange(installs);
            comboBox.SelectedIndex = 0;
            textBox_pass.Enabled = false;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btn_ok_Click(object sender, EventArgs e)
        {
            string path = @"C:\Users\Kirill\source\repos\Lab1\hash.txt";
            string passHash;
            using (FileStream fstream = new FileStream(path, FileMode.Open))
            {
                byte[] array = new byte[fstream.Length];
                fstream.Read(array, 0, array.Length);                
                passHash = Encoding.Default.GetString(array);
            }

            if (passHash == GetHash(comboBox.Text + textBox_pass.Text))
            {
                form.BackColor = Color.Orange;
                dp.Enabled = true;
                tb.Enabled = true;
            }
        }

        private void btn_cancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void comboBox_SelectedIndexChanged(object sender, EventArgs e)
        {

            if (comboBox.Text == "user")
            {
                textBox_pass.Enabled = false;
            }
            else if (comboBox.Text == "admin")
            {
                textBox_pass.Enabled = true;
            }

        }

        public static string GetHash(string input)
        {
            var md5 = MD5.Create();
            var hash = md5.ComputeHash(Encoding.UTF8.GetBytes(input));

            return Convert.ToBase64String(hash);
        }
    }
}
