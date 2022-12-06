import java.util.*;
import java.io.*;
import files.*; 


public class email
{
   
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        ArrayList<data> Data = new ArrayList<data>();
        ListIterator<data>Data_list = null;

        ArrayList<Write_Mail> Mail = new ArrayList<Write_Mail>();
        ListIterator<Write_Mail>Mail_list = null;

        File dir= new File("Datas");
        dir.mkdir();

        File file1 = new File( "Datas//data.txt");
        File file2 = new File( "Datas//mail.txt");

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;


        String add = "a";
        String pass = "a";
        Data.add(new data(add, pass));

        String add2 = "b";
        String pass2 = "b";
        Data.add(new data(add2, pass2));
        
        String add3 = "c";
        String pass3 = "c";
        Data.add(new data(add3, pass3));

        
        
        
        
        oos =new  ObjectOutputStream(new FileOutputStream(file1));
        oos.writeObject(Data);
        oos.close();
        


       

        if(file1.isFile())
        {
            ois = new ObjectInputStream(new FileInputStream(file1));
            Data = (ArrayList<data>)ois.readObject();
            ois.close();
        }
        if(file2.isFile())
        {
            ois = new ObjectInputStream(new FileInputStream(file2));
            Mail = (ArrayList<Write_Mail>)ois.readObject();
            ois.close();
        }

        char mn = '~';
        do
        {

        System.out.print("Enter Email Address : ");
        String in_add = sc.nextLine();
        System.out.print("Enter Password : ");
        String in_pass = sc.nextLine();

        Data_list = Data.listIterator();
        Boolean data_check = false;
        while(Data_list.hasNext())
        {

            data dt =(data)Data_list.next();
            if(in_add.equals(dt.Add) || in_pass.equals(dt.Pass))
            {
                System.out.println("1 .Write E-Mail");
                System.out.println("2 .Inbox");
                System.out.print("Select An Option : ");
                char op = sc1.next().charAt(0);
                switch(op)
                {
                    case '1':
                        System.out.println("From : "+in_add);
                        System.out.print("TO : ");
                        String to=sc.nextLine();
                        System.out.print("Write : ");
                        String write = sc.nextLine();
                        Mail.add(new Write_Mail(to, write));
                        oos = new ObjectOutputStream(new FileOutputStream(file2));
                        oos.writeObject(Mail);
                        oos.close();

                    break;


                    case '2':
                        Mail_list = Mail.listIterator();
                        Boolean mail_check = false;
                        while(Mail_list.hasNext())
                        {
                            Write_Mail mail = (Write_Mail)Mail_list.next();
                            if(in_add.equals(mail.To))
                            {
                                
                                mail.Display();
                                mail_check = true;
                            }
                        }

                        if(mail_check== false)
                        {
                            System.out.println("Empty");
                        }

                    break;

                    
                }


                data_check = true;
            }
        }
        if(data_check==false)
        {
            System.out.println("Dose not match!!!");
        }}while(mn!='0');




    }
}