package files;
import java.io.*;
public class Write_Mail implements elements, Serializable
{
    public String To;
    public String E_mail ;
    public Write_Mail(String q, String r)
    {
        this.To = q;
        this.E_mail= r;
    }
    @Override
    public void Display() {
       System.out.println("To : "+To);
       System.out.println("E - mail : "+E_mail);
    }
}