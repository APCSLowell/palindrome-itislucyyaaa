import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String cleanedWord = noSpaces(noCapitals(onlyLetters(word)));
  String reversedWord = reverse(cleanedWord);
  if(cleanedWord.equals(reversedWord))
    return true;
  else 
    return false;
}

public String reverse(String str)
{
    String sNew = new String();
    for(int i=str.length();i>0; i--){
      sNew=sNew+str.substring(i-1,i);
    }
    return sNew;
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}

public String noSpaces(String sWord){
  String res = "";
  for(int i=0; i<sWord.length(); i++){
    if(sWord.substring(i,i+1).equals(" ")){
      res=res+"";
    }else{
      res=res+sWord.substring(i,i+1);
    }
  }
  return res;
}

public int numLetters(String sString){
  int num=0;
  for(int i=0; i<sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))==true){
      num++;
    }
  }
  return num;
}

public String onlyLetters(String sString){
  String result = new String();
  for(int i=0; i<sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))==true){
      result = result + sString.charAt(i);
    }
  }
  return result;
}
}
