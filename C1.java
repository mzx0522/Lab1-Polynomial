package work1;
import java.util.Scanner;
public class C1 {
	public static void Derivation(StringBuffer beforeD,String x)//��
	{
		StringBuffer afterD=new StringBuffer();
		int count=0;
		int i;
		char item;
		//�ҳ�����������,�������,���Ǳ����Ҳ���*�Ͷ�ȡ
		for(i=0;i<beforeD.length();i++)
		{
			item=beforeD.charAt(i);
			if(item==x.charAt(0))
			{
				count++;
			}
			else if(item!='*')
			{
				afterD.append(item);
			}
		}
		if(count==0)//�����������Ϊ0������Ϊ��
		{
			afterD.delete(0,afterD.length());
		}
		else if(count!=1)//����Ϊ1ʱ�����ϵ��
		{
			afterD.append(Integer.toString(count));
			for(i=0;i<count-1;i++)
			{
				afterD.append(x);
			}
		}
		//�Խ��ʽ����ʽ�Ĵ���
		for(i=0;i<afterD.length()-1;i++)
		{
			//���ֺ�����ϳ˺�*
			if(Character.isDigit(afterD.charAt(i))& !Character.isDigit(afterD.charAt(i+1)))
			{
				afterD.insert(i+1, '*');
			}
			//��ĸ����������ϳ˺�*,�������ĸ�Ҳ������һλ�ͼ���*
			if(Character.isAlphabetic(afterD.charAt(i))&i!=afterD.length()-1)
			{
				afterD.insert(i+1, '*');
			}
		}
		for(i=0;i<afterD.length();i++)
		{
			//ɾ��ÿ������ʽĩβ����ĳ˺�
			if(afterD.charAt(i)=='*'& i==afterD.length()-1)
			{
				afterD.deleteCharAt(i);
			}
		}
		System.out.print(afterD);
	}
	public static void Analyst(StringBuffer str,String x)
	{
		int i;
		char item;
		StringBuffer temp=new StringBuffer();
		for(i=0;i<str.length();i++)
		{
			item=str.charAt(i);
			if(item!='+'&item!='-'&i!=str.length()-1)
			{
				temp.append(item);
			}
			else
			{
				Derivation(temp,x);
				temp.setLength(0);
				temp.append(item);
			}	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuffer str = new StringBuffer();
		String fact,op;
		System.out.println("���������ʽ:");
		System.out.println("�������ɳ��������ұ���Ϊ:x,y,z");
		str.append(input.next());
		System.out.println("������Ķ���ʽ��:");
		System.out.println(str);
		op=input.next();
		if(op.contains("simplify"))
		{
			System.out.println("0");
		}
		else if(op.contains("d/d"))
		{
			fact=input.next();
			if(str.indexOf(fact)!=-1)
			{
				System.out.println("�󵼽��Ϊ:");
				Analyst(str,fact);
			}
			else
			{
				System.out.println("ERROR,No variable");
			}
		}
		else
		{
			System.out.println("������Ķ���ʽ��:");
			System.out.println(str);
		}
		input.close();
	}
}
