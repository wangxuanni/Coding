package interviews.tree;

public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
//ֻ��Ҫ�ж����������Ƿ��б�root�ߵģ���0��ʼҲ����ν��Ϊǰ��һ����С
        if (sequence.length <= 0 || sequence == null)
            return false;
        return ju(sequence, 0, sequence.length - 1);
    }
    static boolean ju(int[] sequence, int star, int root) {
        if ( root <= star) {
            return true;
        }int i = star;
        for (; i < root; i++) {
            if (sequence[i] > sequence[root])
                break;
        }
        for (int j = i; j < root; j++) {
            if (sequence[j] < sequence[root])
                return false;
        }
        return ju(sequence, star, i - 1) && ju(sequence, i, root - 1);
    }
}
