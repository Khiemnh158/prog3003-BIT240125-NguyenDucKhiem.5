public class GenericMethodDemo {

    // 1 & 2: Phương thức tĩnh printArray nhận mảng kiểu E[]
    public static <E> void printArray(E[] inputArray) {
        // 3: In tất cả các phần tử ra màn hình
        for (E element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println(); // Xuống dòng
    }

    // 4: Hàm main để kiểm thử
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++", "JavaScript"};

        System.out.print("Mảng Integer: ");
        printArray(intArray);

        System.out.print("Mảng String: ");
        printArray(stringArray);
    }
}