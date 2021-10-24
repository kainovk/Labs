
namespace Lab1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btn_create = new System.Windows.Forms.Button();
            this.btn_change = new System.Windows.Forms.Button();
            this.btn_del = new System.Windows.Forms.Button();
            this.listBox = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // btn_create
            // 
            this.btn_create.Location = new System.Drawing.Point(27, 38);
            this.btn_create.Name = "btn_create";
            this.btn_create.Size = new System.Drawing.Size(156, 52);
            this.btn_create.TabIndex = 0;
            this.btn_create.Text = "Создать новую запись";
            this.btn_create.UseVisualStyleBackColor = true;
            this.btn_create.Click += new System.EventHandler(this.btn_create_Click);
            // 
            // btn_change
            // 
            this.btn_change.Location = new System.Drawing.Point(27, 115);
            this.btn_change.Name = "btn_change";
            this.btn_change.Size = new System.Drawing.Size(156, 52);
            this.btn_change.TabIndex = 1;
            this.btn_change.Text = "Изменить выбранную";
            this.btn_change.UseVisualStyleBackColor = true;
            this.btn_change.Click += new System.EventHandler(this.btn_change_Click);
            // 
            // btn_del
            // 
            this.btn_del.Location = new System.Drawing.Point(27, 199);
            this.btn_del.Name = "btn_del";
            this.btn_del.Size = new System.Drawing.Size(156, 52);
            this.btn_del.TabIndex = 2;
            this.btn_del.Text = "Удалить выбранную";
            this.btn_del.UseVisualStyleBackColor = true;
            this.btn_del.Click += new System.EventHandler(this.btn_del_Click);
            // 
            // listBox
            // 
            this.listBox.FormattingEnabled = true;
            this.listBox.Location = new System.Drawing.Point(256, 38);
            this.listBox.Name = "listBox";
            this.listBox.Size = new System.Drawing.Size(396, 212);
            this.listBox.TabIndex = 4;
            this.listBox.SelectedIndexChanged += new System.EventHandler(this.listBox_SelectedIndexChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.listBox);
            this.Controls.Add(this.btn_del);
            this.Controls.Add(this.btn_change);
            this.Controls.Add(this.btn_create);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btn_create;
        private System.Windows.Forms.Button btn_del;
        private System.Windows.Forms.ListBox listBox;
        public System.Windows.Forms.Button btn_change;
    }
}

