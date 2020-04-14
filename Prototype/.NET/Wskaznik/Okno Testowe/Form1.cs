using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Okno_Testowe
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.SuspendLayout();
            // 
            // OknoTestowe
            // 
            this.ClientSize = new System.Drawing.Size(1000, 300);
            this.Name = "OknoTestowe";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Prototyp";
            this.ResumeLayout(false);
        }
    }
}
