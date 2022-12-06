package files;
import java.io.*;

interface elements
{
    public void Display();
}


public class data implements Serializable {
    
        public String Add;
        public String Pass;
        public data(String m,String n)
        {
            this.Add = m;
            this.Pass = n;
        }
    
}



