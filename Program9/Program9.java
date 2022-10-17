import java.io.*;
class replacepage
{
  public static void main(String args[])throws IOException
  {
    BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
    int f,page=0,ch,pgf=0,n,chn=0;
    boolean flag;
    int pages[]; 	
    do
    {
      System.out.println("1.FIFO");
      System.out.println("2.LRU");
      System.out.println("3.EXIT");
      System.out.println("ENTER YOUR CHOICE: ");
      ch=Integer.parseInt(obj.readLine());      
      switch(ch)
      {
        case 1:	int pt=0;
                System.out.println("Enter Number of Frames: ");
                f=Integer.parseInt(obj.readLine());
                int frame[]=new int[f];
                for(int i=0;i<f;i++)
                {
                  frame[i]=-1;
                }
                System.out.println("Enter The Number of Pages: ");
                n=Integer.parseInt(obj.readLine());
                pages=new int[n];
                System.out.println("Enter The Page Number: ");
                for(int j=0;j<n;j++)
                  pages[j]=Integer.parseInt(obj.readLine());
                do
                {
                  int pg=0;
                  for(pg=0;pg<n;pg++)
                  {
                    page=pages[pg];
                    flag=true;
                    for(int j=0;j<f;j++)
                    {
                      if(page==frame[j])	
                      {
                        flag=false;      
                        break;
                      }
                    }
                    if(flag)
                    {
                      frame[pt]=page;
                      pt++;
                      if(pt==f)
                        pt=0;
                      System.out.print("Frame: ");
                      for(int j=0;j<f;j++)
                        System.out.print(frame[j]+"   ");
                      System.out.println(); 
                      pgf++;
                    }
                    else
                    {
                      System.out.print("Frame :");
                      for(int j=0;j<f;j++)
                      System.out.print(frame[j]+"  ");
                      System.out.println();
                    }
                    chn++;
                  }
                } while(chn!=n);
                System.out.println("Page Fault: " + pgf);
                break;
        case 2: int k=0;
                System.out.println("Enter Number of Frames: ");
                f=Integer.parseInt(obj.readLine());
                int frame1[]=new int[f];
                int a[]=new int[f];
                int b[]=new int[f];
                for(int i=0;i<f;i++) 
                {
                  frame1[i]=-1;
                  a[i]=-1;
                  b[i]=-1;
                }
                System.out.println("Enter The Number of Pages ");
                n=Integer.parseInt(obj.readLine());
                pages=new int[n];
                System.out.println("Enter The Page Number: ");
                for(int j=0;j<n;j++)
                  pages[j]=Integer.parseInt(obj.readLine());
                do
                {
                  int pg=0;
                  for(pg=0;pg<n;pg++) 
                  {
                    page=pages[pg];
                    flag=true;
                    for(int j=0;j<f;j++)
                    {
                      if(page==frame1[j])
                      {
                        flag=false; 
                        break;
                      }
                    }
                    for(int j=0;j<f && flag;j++)
                    {
                      if(frame1[j]==a[f-1])
                      {
                        k=j;
                        break;
                      }
                    }
                    if(flag)
                    {
                      frame1[k]=page;
                      System.out.println("Frame :" );
                      for(int j=0;j<f;j++)
                        System.out.print(frame1[j]+"  ");
                      pgf++;
                      System.out.println();
                    }
                    else
                    {
                      System.out.println("Frame :" );
                      for(int j=0;j<f;j++)
                        System.out.print(frame1[j]+"  ");
                      System.out.println();
                    }
                    int p=1;
                    b[0]=page;
                    for(int j=0;j<a.length;j++)
                    {
                      if(page!=a[j] && p<f)
                      {
                        b[p]=a[j];
                        p++;
                      }
                    }
                    for(int j=0;j<f;j++)
                    {
                      a[j]=b[j];
                    }
                    chn++;
                  }
                } while(chn!=n);
                System.out.println("Page Fault: "+pgf);
                break;
        case 3:	break;
      }
    } while(ch!=3);
  }
}
