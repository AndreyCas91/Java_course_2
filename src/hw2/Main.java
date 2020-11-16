package hw2;

public class Main {
    public static void main(String[] args) {
        String[][] str = {
                {"1", "1", "1", "1"},
                {"1", "1", "2", "1"},
                {"1", "w", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try{
            stringArr(str);
        } catch (MyArraySizeException e){
            System.out.println("Массив не 4x4");
        } catch (MyArrayDataException e){
             System.out.println(e.getMessage());
        }

        System.out.println("End");
    }

    static void stringArr(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        if(arr.length != 4 || arr[0].length != 4){
            throw new MyArraySizeException("Невено");
        }
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(!check(arr[i][j])){
                    throw new MyArrayDataException("Массив содержит символ или букву в ячейке: " + i +"," + j, i, j);
                }
                x = x + Integer.parseInt(arr[i][j]);
            }
        }
        System.out.println("Сумма всех значений массива равна: " + x);
    }

    static boolean check(String str){
        try{
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
