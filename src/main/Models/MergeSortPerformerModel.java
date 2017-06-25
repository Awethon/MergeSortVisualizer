/**
 * Created by alexthor on 25.06.17.
 */
public class MergeSortPerformerModel implements ISortPerformer {

    private StateSaverModel saver;
    private int[] sequence;

    @Override
    public void setSequence(int[] sequence){
        this.sequence = sequence;
    }

    public MergeSortPerformerModel() {
        this.saver = new StateSaverModel();
    }

    private int[] MergeSort(int[] sequence, int left, int right) {
        if(left < right)
        {
            int middle = (left+right)/2;
            int[] first = MergeSort(sequence, left, middle);
            int[] second = MergeSort(sequence, middle + 1, right);
            saveState(first, second, left, right);
            int[] result = Merge(first, second);
            return result;
        }
        int[] result = new int[] { sequence[left] };
        saveState(result, null, left, right);
        return result;
    }

    private int[] Merge(int[] first, int[] second) {
        int iter1 = 0, iter2 = 0, iter3 = 0;
        int firstLength = (first == null)? 0 : first.length;
        int secondLength = (first == null)? 0 : second.length;
        int[] result = new int[firstLength + secondLength];
        while (iter1 < firstLength && iter2 < secondLength)
        {
            if(first[iter1] <= second[iter2])
            {
                result[iter3] = first[iter1];
                iter3++;
                iter1++;
            }
            else
            {
                result[iter3] = second[iter2];
                iter3++;
                iter2++;
            }
        }
        while (iter1 < firstLength)
        {
            result[iter3] = first[iter1];
            iter3++;
            iter1++;
        }
        while (iter2 < secondLength)
        {
            result[iter3] = second[iter2];
            iter3++;
            iter2++;
        }
        return result;
    }

    private void saveState(int[] first, int[] second, int left, int right) {
        saver.saveState(new State(first, second, left, right));
    }

    @Override
    public StateSaverModel performSort() {
        MergeSort(sequence, 0, sequence.length - 1);
        return saver;
    }
}