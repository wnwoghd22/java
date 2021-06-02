Library Program

자바프로그래밍 001 2조

여러분이 바쁘기도 하고 자바에 대해 아직 익숙지 않은 것 같아 일종의 가이드라인을 만들었습니다.
여러분이 할 일은 비어있는 필드 및 메소드 추가, 또한 아직 만들지 않은 유도클래스 파일 생성입니다.
(Account 쪽은 비어있는 Normal 유도클래스 파일이, 
Book 쪽은 비어있는 Journal 유도클래스 파일이 각각 만들어져 있습니다.)
Handler class는 상호작용이 다소 복잡하니 할 수 있는 만큼만 하시면 됩니다.
현재 가이드라인은 패키지 설정 및 유도 관계, 그리고 약간의 메소드만 나타내고 있습니다.

별도의 외부 라이브러리 추가 없이 입출력 처리를 하기로 했습니다.
다만, 그에 맞춰 각 클래스에는 문자열 배열을 받는 생성자를 만들어야 합니다.(이건 입출력 담당이 만들면 됩니다)

예제에서는 테스트 클래스로 A를 만들어 놨는데, A.java랑 testFM.java는 이를 위한 것이므로 무시하시면 됩니다.
(csv파일 입출력이 어떻게 이루어지는지 보고 싶다면 봐도 됨)

Library
|
|- Account - Borrower 
|   | (BorrowedBook)
|   |-Normal
|   |-Student
|   |-Professor
|  ┗Librarian
|
|- Book
|   |
|   |-General
|   |-Journal
|  ┗EBook
|
┗FileManager
    |-AccountFileManager
   ┗BookFileManager

Account 클래스에서는 Borrower 인터페이스를 상속받지만, abstract class이므로 당장 메소드를 구현하지는 않습니다.
하지만, Account 유도클래스에서는 이를 제대로 구현해줄 필요가 있습니다.

compile 할 때에는 javac -d . *.java 입력.
execute 할 때에는 java Library.Library 입력.

현재 java 파일들로 컴파일을 하면 추상함수 구현을 하지 않아서 컴파일 에러가 뜹니다.

+ Account 클래스에 추가된 메소드 - ShowBookList() : borrowedBook이 default로 선언되었으므로 외부에서
접근하고자 할 때 메소드가 별도로 필요하므로 추가함.



