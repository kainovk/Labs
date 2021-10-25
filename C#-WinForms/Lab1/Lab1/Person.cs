using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab1
{
    class Person : IPerson
    {
        int cardNumber;
        string name;
        DateTime birthday;

        public Person() { }

        public Person(DateTime date)
        {
            birthday = date;
        }

        public int CardNumber { get { return cardNumber; } set { cardNumber = value; } }

        public string Name { get { return name; } set { name = value; } }

        public DateTime Bithday { get { return birthday; } set { birthday = value; } }

        public int calcAge(DateTime date)
        {
            int yearAdd = 0;
            if (date.DayOfYear <= this.Bithday.DayOfYear)
            {
                yearAdd++;
            }

            int res = -1;
            if (this.Bithday.Year <= date.Year)
            {
                res = DateTime.Now.Year - (this.Bithday.Year + yearAdd);
            }
            return res;
        }
    }
}
