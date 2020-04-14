using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Wskaznik
{
    public partial class UserControl1 : UserControl
    {
        private int max;
        private int min;
        private int value;

        public UserControl1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (int.TryParse(textBox1.Text, out min))
            {
                progressBar1.Minimum = min; 
            }
            else
            {
                //parsing failed. 
            }
            if (int.TryParse(textBox2.Text, out max))
            {
                 progressBar1.Maximum = max;
            }
            else
            {
                //parsing failed. 
            }
            Random r = new Random();
            int value = r.Next(min, max);
            progressBar1.Value = value;
        }
    }
}
