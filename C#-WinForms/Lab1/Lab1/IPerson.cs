﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab1
{
    public interface IPerson
    {
        int CardNumber { get; }
        string Name { get; }
        DateTime Bithday { get; }
        int calcAge(DateTime date);
    }
}
