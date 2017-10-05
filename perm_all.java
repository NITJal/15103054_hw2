public class perm_all {
	public int num = 0;

	public String[] s;

	public perm_all(int n)

	{

		s = new String[n];

	}
    public static int fact(int n) {

        if (n == 0) {

            return 1;

        }
        int fact = 1;

        for (int i = 1; i <= n; i++) {

            fact *= i;

        }

        return fact;
    }
	public String swap(String a, int i, int j)
    {
		char temp;
        char[] charArray = a.toCharArray();
	    temp = charArray[i] ;
	    charArray[i] = charArray[j];
	    charArray[j] = temp;
	    return String.valueOf(charArray);
    }
    public void permutation(String str, int l, int r)
    {
        if (l == r)
        	s[num++] = str;
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);

                permutation(str, l+1, r);

                str = swap(str,l,i);
            }
        }
    }
	public static void main(String args[])
	{
		String str = "AACE";
		perm_all[] a = new perm_all[str.length()];

		for(int k=0; k < str.length(); k++)
		{
			int n = k+1;
			n = fact(n);
			a[k] = new perm_all(n);
			a[k].permutation(str.substring(0,k+1),0,k);

			String t = new String();
			for(int i=0; i<a[k].s.length; i++)
			{
				for(int j=i+1; j<a[k].s.length; j++)
				{
					if(a[k].s[i].compareTo(a[k].s[j]) > 0)
					{
						t = a[k].s[i];

						a[k].s[i] = a[k].s[j];

						a[k].s[j] = t;
					}
				}
			}


			System.out.println("Length "+(k+1));
			for(int i=0;i<a[k].s.length;i++)
			{
				boolean isDist = true;
				for(int j=0;j<i;j++)
				{
					if(a[k].s[i].compareTo(a[k].s[j]) == 0)
					{
						isDist = false;
						break;
					}
				}
				if(isDist)
				{
					System.out.println(a[k].s[i]);
				}

			}

		}

	}

}
