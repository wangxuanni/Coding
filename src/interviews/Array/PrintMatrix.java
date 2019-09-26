package interviews.Array;

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length < 1) {
            return list;
        }
        int lieSta = 0;
        int hangSta = 0;
        int hangEnd = matrix.length - 1;
        int lieEend = matrix[0].length - 1;
        // ��ӡ�ϱ�һ����
        //һ�����
        if (hangSta == lieEend) {
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][hangSta]);
            }
            return list;
        }        //һ������
        if (lieSta == hangEnd) {
            for (int i = 0; i < matrix[0].length; i++) {
                list.add(matrix[hangEnd][i]);
            }
            return list;
        }
        while (lieSta <= lieEend && hangEnd >= hangSta) {
            int hang = lieSta, lie = hangSta;
            for (lie = lieSta; lie <= lieEend; lie++) {
                list.add(matrix[hang][lie]);
            }
            lie--;
            for (hang = hangSta+1; hang <= hangEnd; hang++) {
                list.add(matrix[hang][lie]);
            }
            hang--;
            if (hangSta != hangEnd)
                for (lie = lieEend - 1; lie >= lieSta; lie--) {
                    list.add(matrix[hang][lie]);

                }
            lie++;
            if (lieSta != lieEend)
                for (hang = hangEnd - 1; hang > hangSta; hang--) {
                    list.add(matrix[hang][lie]);

                }
            lieSta++;
            hangSta++;
            lieEend--;
            hangEnd--;
        }
        return list;
    }

}
