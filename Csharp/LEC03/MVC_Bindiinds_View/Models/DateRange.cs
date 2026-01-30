using System;

namespace MVC_Bindiinds_View.Models
{
    public class DateRange
    {
        public DateTime From { get; private set; }
        public DateTime To { get; private set; }

        public DateRange(DateTime from, DateTime to)
        {
            From = from;
            To = to;
        }
    }
}