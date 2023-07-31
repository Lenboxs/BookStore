
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Arrays
{
    class Program
    {
        static void Question()
        {
            Console.WriteLine("Select one of the following:");
            Console.WriteLine("1. Show all the Unit Standard Codes");
            Console.WriteLine("2. Order all the Unit Standard Codes");
            Console.WriteLine("3. How Many Unit Standard Codes are there?");
            Console.WriteLine("4. what is the Maximum Code?");
            Console.WriteLine("5. What is the Minimum Code?");
            Console.WriteLine("6. Show all the Names");
            Console.WriteLine("7. Order all the Names");
            Console.WriteLine("8. How Many Names are there");
            Console.WriteLine("9. Exit");      
        }
        static void ShowCodes(int[] codes)
        {
            for (int i = 0; i < codes.Length; i++)
            {
                Console.WriteLine(codes[i]);
            }
        }
        static void ShowOrderCodes(int[] codes)
        {
            Array.Sort(codes);
            for (int i = 0; i < codes.Length; i++)
            {
                Console.WriteLine(codes[i]);
            }
        }
        static void ShowAmountCodes(int[] codes)
        {
            Console.WriteLine(codes.Length);
        }
        static void ShowMaxCodes(int[] codes)
        {
            Console.WriteLine(codes.Max());
        }
        static void ShowMinCodes(int[] codes)
        {
            Console.WriteLine(codes.Min());
        }
        static void ShowNames(string[] names)
        {
            for (int i = 0; i < names.Length; i++)
            {
                Console.WriteLine(names[i]);
            }
        }
        static void ShowOrderNames(string[] names)
        {
            Array.Sort(names);
            for (int i = 0; i < names.Length; i++)
            {
                Console.WriteLine(names[i]);
            }
        }
        static void ShowAmountNames(string[] names)
        {
            Console.WriteLine(names.Length);
        }


        static void Main(string[] args)
        {
            int[] codes = {115790,114051,115431,114059,115358,114044,13099,115385,258836,259277,115378,114049,115392,386053,386056,386054,386055,115384};
            string[] names = {"YOLEKA", "XOLILE","LUTHO","AFIKILE","SALIZWA","SHAUN","Q-N","KERMIT","XOLISA","FATIMA","LIHLE","MPHUMUTSENG","SIYAVUYA","AZOLA","CHAD","HLONIPHILE","AMBROSE","KHANYISA","NDIKHOKELE","IZAYHE","NDIMPHIWE","LEONARD"};
            Question();

            for (int i = 0; i < 50; i++)
            {
                int num = Convert.ToInt32(Console.ReadLine());
                if(num == 1)
                {
                    ShowCodes(codes);
                }
                else  if(num == 2)
                {
                    ShowOrderCodes(codes);
                }
                else if(num == 3)
                {
                    ShowAmountCodes(codes);
                }
                else if(num == 4)
                {
                    ShowMaxCodes(codes);
                }
                else if(num == 5)
                {
                    ShowMinCodes(codes);
                }
                else if(num == 6)
                {
                    ShowNames(names);
                }
                else if(num == 7)
                {
                    ShowOrderNames(names);
                }
                else  if(num == 8)
                {
                    ShowAmountNames(names);
                }
                else
                {
                    break;
                }
              
            }


        }
    }
}
