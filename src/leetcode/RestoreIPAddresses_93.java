package leetcode;

import java.util.ArrayList;

/**
 * Created by shelvin on 9/9/16 at 02:19.
 */

public class RestoreIPAddresses_93
{

    public ArrayList<String> restoreIPAddress(String str)
    {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        if (str.length() < 4 || str.length() > 12)
        {
            return result;
        }

        helper(result, list, str, 0);
        return result;
    }


    public void helper(ArrayList<String> result, ArrayList<String> list, String str, int start)
    {
        if (list.size() == 4)
        {
            if (start != str.length())
            {
                return;
            }

            StringBuilder stringBuffer = new StringBuilder();
            for (String string : list)
            {
                stringBuffer.append(string);
                stringBuffer.append(".");
            }

            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            result.add(stringBuffer.toString());
        }

        for (int i = start; i < str.length() && i < start + 3; i++)
        {
            String s = str.substring(start, i + 1);
            if (isValid(s))
            {
                list.add(s);
                helper(result, list, str, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isValid(String str)
    {
        if (str.charAt(0) == 0)
        {
            return str.equals("0");
        }

        int digit = Integer.parseInt(str);
        return digit >= 0 && digit <= 255;
    }
}
