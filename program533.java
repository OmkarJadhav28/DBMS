import java.util.*;

class program529
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();
        obj.StartDBMS();

        obj.InsertIntoTable("Rahul",23,89);
        obj.InsertIntoTable("Sagar",26,98);
        obj.InsertIntoTable("Pooja",20,56);
        obj.InsertIntoTable("Sayali",30,78);
        obj.InsertIntoTable("Tejas",29,68);

        obj.SelectFrom();
        obj.SelectFrom(4);

        System.out.println("maximum marks are : "+obj.Aggregate_Max());
        System.out.println("Minimum marks are : "+obj.Aggregate_Min());
        System.out.println("Addition of marks are : "+obj.Aggregate_SUM());
    }
}

class Student
{
    public int Rno;
    public String Name;
    public int Age;
    public int Marks;

    public static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int X, int Y)
    {
        this.Rno = ++Generator;
        this.Name = str;
        this.Age = X;
        this.Marks = Y;
    }

    public void Display()
    {
        System.out.println(this.Rno + " " + this.Name + " " + this.Age + " " + this.Marks);
    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList <Student> ();
    }

    public void StartDBMS()
    {
        System.out.println("Marvellous DBMS started successfull...");
        System.out.println("Table Schema created successfully...");
    }

    //insert into table student values(-----,---,-----)
    public void InsertIntoTable(String name, int age, int marks)
    {
        Student sobj = new Student(name,age,marks);
        lobj.add(sobj);
    }

    //Select * from student
    public void SelectFrom()
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            sref.Display();
        }
    }

    //select * from student where Rno = 11
    public void SelectFrom(int no)
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            if(sref.Rno == no)
            {
                sref.Display();
                break;
            }
        }
    }

    //select * from student where Name = 'Rahul'
    public void SelectFrom(String str)
    {
        System.out.println("Records from the student table are : ");

        for(Student sref : lobj)
        {
            if(sref.equals(sref.Name))
            {
                sref.Display();
                break;
            }
        }
    }

    // Select MAX(marks) from student
    public int Aggregate_Max()
    {
        Student temp = lobj.get(0);
        int iMax = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks > iMax)
            {
                iMax = sref.Marks;
            }
        }
        return iMax;
    }

    // Select MIN(marks) from student
    public int Aggregate_Min()
    {
        Student temp = lobj.get(0);
        int iMin = temp.Marks;

        for(Student sref : lobj)
        {
            if(sref.Marks < iMin)
            {
                iMin = sref.Marks;
            }
        }
        return iMin;
    }

    // Select SUM(marks) from student
    public int Aggregate_SUM()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return iSum;
    }

    // Select AVG(marks) from student
    public float Aggregate_AVG()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Marks;
        }
        return iSum;
    }
}