package session1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
        public static void main(String[] args) {
                HashSet<String> hs = new HashSet<>();
                hs.add("Hello");
                hs.add("World");
                hs.add("Hello"); // Set sẽ ko có sự trùng nhau
                hs.add("World");
                for (String s: hs) {
                        System.out.println(s);
                }
                PriorityQueue<Integer> numbers = new PriorityQueue<>();
                numbers.add(4);
                numbers.add(1);
                numbers.add(2);
                System.out.println("Numbers: " + numbers);
                int first = numbers.peek();
                System.out.println("first: " + first);
                System.out.println("Total: " + numbers.size());

                System.out.println("Poll: " + numbers.poll() + " remain: " + numbers.size());
                System.out.println("Poll: " + numbers.poll() + " remain: " + numbers.size());
                System.out.println("Poll: " + numbers.poll() + " remain: " + numbers.size());

                PriorityQueue<Student> st = new PriorityQueue<>(new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                                return o2.getMark() - o1.getMark();
                        }
                });
                st.add(new Student("Nguyễn Tuấn Anh", 1));
                st.add(new Student("Cao Hoàng Nam", 3));
                st.add(new Student("Trần Văn Thành", 2));
                st.add(new Student("Hà Hoàng Hưng", 6));
                Student s;
//                while((s = st.poll()) != null ) {
//                        System.out.println("SV: " + s.getName() + "   Điểm thi: " + s.getMark());
//                }
                while(st.size() > 0) {
                        s = st.poll();
                        System.out.println("SV: " + s.getName() + "   Điểm thi: " + s.getMark());
                }

                HashMap<String,Integer> hm = new HashMap<>();
                hm.put("good_student",10);
                hm.put("bad_student",3);
                System.out.println("Tiêu chuẩn làm sinh viên xuất săc là điểm thi phải đạt: " +
                        hm.get("good_student"));
                System.out.println(hm.keySet());
                System.out.println(hm.values());
                System.out.println(hm);
        }
}
