import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Hyman Cheung

public class SetMeal {
  /*---------------------------------------loginCatalongue---------------------------------------*/
  public static String[] loginCatalongue = { "Login", "Creat Account", "Forgot Password" };
  /*----------------------------------------CreatAccount-----------------------------------------*/
  public static String[][] account = new String[99999][2];

  // Name
  public static String stafName;
  public static String[] capitalized = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "N", "O", "P", "Q",
      "R", "S", "L", "W", "T", "Y", "U", "Z", "X", "V" };
  public static boolean isCapitalized;

  // Password
  public static String[] capitalized2 = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "N", "O", "P",
      "Q", "R", "S", "L", "W", "T", "Y", "U", "Z", "X", "V", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m",
      "n", "o", "p", "q", "r", "s", "l", "w", "t", "y", "u", "z", "x", "v" };
  public static String password;
  public static boolean threeLetters;

  /*-----------------------------------------------Date and Time------------------------------------------------*/
  public static Date D = new Date();
  public static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
  public static SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
  /*----------------------------------------------MainCatalongue---------------------------------------------- */

  public static String[] mainCatalongue = { "Order", "Member", "Basket", "Record", "Logout" };
  public static double turnover;
  public static int orderNumber = 0;
  public static String[] record = new String[9999999];
  /*-------------------------------------------------Order----------------------------------------------------*/
  // mainCource
  public static String[] mainCource = { "滋味雞塊", "脆香雞翼", "脆辣雞腿包", "板燒雞腿包", "魚柳包", "玉子牛堡", "香烤雞翼", "雙層芝士孖堡", "豬柳漢堡",
      "豬柳蛋漢堡" };
  public static double[] mainCourcePrice = { 25, 35, 28, 33, 32, 22, 32, 26, 30, 36 };
  // drink
  public static String[] drink = { "可樂汽水", "橙味汽水", "熱朱古力", "凍新鮮檸檬茶", "凍港式奶茶 ", "青蘋果梳打茶" };
  public static double[] drinkPrice = { 0, 0, 0, 3, 3, 4.5 };
  // snack
  public static String[] snack = { "薯條 \t", "粟米杯\t" };
  public static double[] snackPrice = { 0, 0 };
  // all
  public static double mainCource_price, drink_price, snack_price;
  public static String mainCource_oder, drink_oder, snack_oder;
  // total
  public static String[][] totalOrder = new String[100][6];
  public static double[] totalPrice = new double[100];
  // 每個客人下了多少單
  public static int count;

  /*----------------------------------------Basket and CheckOut-------------------------------------------*/
  // Basket
  public static String[] basket = { "Delete", "Check Out", "Back" };
  // CheckOut
  public static double pay;
  public static DecimalFormat df1 = new DecimalFormat("#.#");

  /*----------------------------------------------Member-------------------------------------------------*/
  // Member Catalongue
  public static String[] catalongue = { "Delete Member", "Check Member", "Create Member", "Back" };

  // Create Member
  public static int memberNumber;
  public static String memberNumberString;
  public static String[][] member = new String[9999999][2];
  public static Random NewMember = new Random();
  public static String memberName;

  // Check Member
  public static int isMember, checkmember;
  public static String inputMemberNumber;

  // Delete Member
  public static String deleteMember;

  /*-------------------------------------------------Scanner--------------------------------------------*/
  public static Scanner s = new Scanner(System.in);
  public static int choose;
  /*----------------------------------------------------------------------------------------------------*/

  public static void main(String[] args) {
    while (true) {
      for (int i = 0; i < loginCatalongue.length; i++) {
        System.out.println("(" + (i + 1) + ")" + loginCatalongue[i]);
      }
      System.out.print("(1)-" + "(" + (loginCatalongue.length) + ")" + ": ");
      choose = s.nextInt();
      System.out.println("");

      if (choose == 1) {
        Login();
      } else if (choose == 2) {
        account = CreatAccount(account);
      } else if (choose == 3) {
        account = ForgotPassword(account);
      }
    }
  }

  /*---------------------------------------Login---------------------------------------*/
  public static void Login() {
    while (true) {
      System.out.println("-------------------Login-------------------\n");
      System.out.print("Please enter your name[(2)Back!]: "); // 設定名字
      stafName = s.next();
      System.out.println("");
      if (stafName.equals("2")) {
        break;
      } else {
        for (int i = 0; i < account.length; i++) {
          if (stafName.equals(account[i][0])) {
            while (true) {
              System.out.print("Please enter your password[(2)Back!]: ");
              password = s.next();
              System.out.println("");

              if (password.equals(account[i][1])) {
                MainCatalongue();
                break;
              }
            }
          }
        }
      }
    }
  }

  /*---------------------------------------CreatAccount---------------------------------------*/
  public static String[][] CreatAccount(String[][] account) {

    while (true) {
      System.out.print("Please enter your name[(2)Back!]: "); // 設定名字
      stafName = s.next();
      System.out.println("");
      for (int i = 0; i < capitalized.length; i++) // 檢查第一個字母是否大寫
      {
        if (stafName.substring(0, 1).equals(capitalized[i])) {
          isCapitalized = true;
          break;
        } else {
          isCapitalized = false;
        }
      }
      if (stafName.equals("2")) {
        return account;
      } else if (stafName.length() >= 3 && isCapitalized == true) {
        for (int i = 0; i < account.length; i++) {
          if (stafName.equals(account[i][0])) {
            System.out.println("The name has been taken!\n");
            break;
          } else if (account[i][0] == null) {
            account[i][0] = stafName;

            while (true) {
              System.out.print("Please set your password[(2)Back!]: "); // 設定密碼
              password = s.next();
              System.out.println("");

              for (int j = 0; j < capitalized.length; j++) // 檢查首三個是否字母，及第一個是否大寫
              {
                if (password.substring(0, 1).equals(capitalized[j])) {
                  for (int k = 0; k < capitalized2.length; k++) {
                    if (password.substring(1, 2).equals(capitalized2[k])) {
                      for (int a = 0; a < capitalized2.length; a++) {
                        if (password.substring(2, 3).equals(capitalized2[a])) {
                          threeLetters = true;
                          break;
                        } else {
                          threeLetters = false;
                        }
                      }
                      break;
                    } else {
                      threeLetters = false;
                    }
                  }
                  break;
                } else {
                  threeLetters = false;
                }
              }
              if (password.equals("2")) {
                account[i][0] = null;
                return account;
              } else if (password.length() < 8) {
                System.out.println("The password must be longer than eight letters!\n");
              } else if (threeLetters == false) {
                System.out
                    .println("The first three must be English letters and the first letter must be capitalized!\n");
              } else if (password.length() >= 8 && threeLetters == true) {
                for (int j = 0; j < account.length; j++) {
                  if (password.equals(account[j][1])) {
                    System.out.println("The password has been taken!\n");
                    break;
                  } else if (account[j][1] == null) {
                    account[i][1] = password;
                    System.out.println("You created a new account!\n");
                    return account;
                  }
                }
              }
            }
          }
        }
      } else {
        System.out
            .println("The first letter must be capitalized and the staf name must be longer than three letters!\n");
      }
    }
  }

  /*---------------------------------------ForgotPassword---------------------------------------*/
  public static String[][] ForgotPassword(String[][] account) {
    while (true) {
      System.out.print("Please enter your name[(2)Back!]: ");
      stafName = s.next();
      System.out.println("");
      if (stafName.equals("2")) {
        return account;
      } else {
        for (int i = 0; i < account.length; i++) {
          if (stafName.equals(account[i][0])) {
            while (true) {
              System.out.print("Please set your new password[(2)Back!]: "); // 重設密碼
              password = s.next();
              System.out.println("");

              for (int j = 0; j < capitalized.length; j++) // 檢查首三個是否字母，及第一個是否大寫
              {
                if (password.substring(0, 1).equals(capitalized[j])) {
                  for (int k = 0; k < capitalized2.length; k++) {
                    if (password.substring(1, 2).equals(capitalized2[k])) {
                      for (int a = 0; a < capitalized2.length; a++) {
                        if (password.substring(2, 3).equals(capitalized2[a])) {
                          threeLetters = true;
                          break;
                        } else {
                          threeLetters = false;
                        }
                      }
                      break;
                    } else {
                      threeLetters = false;
                    }
                  }
                  break;
                } else {
                  threeLetters = false;
                }
              }
              if (password.equals("2")) {
                return account;
              } else if (password.length() < 8) {
                System.out.println("The password must be longer than eight letters!\n");
              } else if (threeLetters == false) {
                System.out
                    .println("The first three must be English letters and the first letter must be capitalized!\n");
              } else if (password.length() >= 8 && threeLetters == true) {
                for (int j = 0; j < account.length; j++) {
                  if (password.equals(account[j][1])) {
                    System.out.println("The password has been taken!\n");
                    break;
                  } else if (account[j][1] == null) {
                    account[i][1] = password;
                    System.out.println("The password was reset successfully!\n");
                    return account;
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  /*----------------------------------------------MainCatalongue----------------------------------------*/
  public static void MainCatalongue() {
    while (true) {
      for (int i = 0; i < mainCatalongue.length; i++) {
        System.out.println("(" + (i + 1) + ")" + mainCatalongue[i]);
      }
      System.out.print("(1)-" + "(" + (mainCatalongue.length) + ")" + ": ");
      choose = s.nextInt();
      System.out.println("");
      if (choose == 1) {
        totalPrice = Order(totalOrder);
      } else if (choose == 2) {
        member = Member(member);
      } else if (choose == 3) {
        totalPrice = Basket(totalPrice);
      } else if (choose == 4) { // 查看營業額
        if (orderNumber > 0) {
          System.out.println("-------------------Record------------------\n");
          for (int i = 0; i <= orderNumber; i++) {
            if (record[i] != null) {
              System.out.println("-------------------(" + "00" + (i + 1) + ")-------------------\n");
              System.out.println(record[i] + "\n");
            }
          }
          System.out
              .println(
                  "___________________________________________\n\n" + "Total Order: " + (orderNumber) + "\nTurnover:"
                      + "\t\t$"
                      + df1.format(turnover) + "\n");
        }
      } else if (choose == 5) {
        break;
      }
    }
  }

  /*---------------------------------------------Order---------------------------------------------*/

  public static double[] Order(String totalOrder[][]) {
    while (true) {
      while (true) {
        System.out.println("------------Main Cource------------");
        for (int i = 0; i < mainCource.length; i++) {
          System.out.println("(" + (i + 1) + ")" + mainCource[i] + "\t\t" + "$" + mainCourcePrice[i]);
        }
        System.out.print("(0)Back\n" + "(0)-" + "(" + (mainCource.length) + ")" + ": ");
        choose = s.nextInt();
        System.out.println("");
        if (choose > 0 && choose < 11) {
          mainCource_oder = mainCource[choose - 1];
          mainCource_price = mainCourcePrice[choose - 1];
          System.out.println("+ " + mainCource_oder + "\t$" + mainCource_price);
          System.out.println("");
          break;
        } else if (choose == 0) {
          return totalPrice;
        }
      }

      while (true) {
        System.out.println("---------------Drink---------------");
        for (int i = 0; i < drink.length; i++) {
          System.out.println("(" + (i + 1) + ")" + drink[i] + "\t\t" + "$" + drinkPrice[i]);
        }
        System.out.print("(0)Back\n" + "(0)-" + "(" + (drink.length) + ")" + ": ");
        choose = s.nextInt();
        System.out.println("");
        if (choose > 0 && choose < 7) {
          drink_oder = drink[choose - 1];
          drink_price = drinkPrice[choose - 1];
          System.out.println("+ " + drink_oder + "\t$" + drink_price);
          System.out.println("");
          break;
        } else if (choose == 0) {
          return totalPrice;
        }
      }

      while (true) {
        System.out.println("---------------Snack---------------");
        for (int i = 0; i < snack.length; i++) {
          System.out.println("(" + (i + 1) + ")" + snack[i] + "\t" + "$" + snackPrice[i]);
        }
        System.out.print("(0)Back\n" + "(0)-" + "(" + (snack.length) + ")" + ": ");
        choose = s.nextInt();
        System.out.println("");
        if (choose > 0 && choose < 3) {
          snack_oder = snack[choose - 1];
          snack_price = snackPrice[choose - 1];
          System.out.println("+ " + snack_oder + "\t$" + snack_price);
          System.out.println("");
          break;
        } else if (choose == 0) {
          return totalPrice;
        }
      }

      System.out.println(
          "------Oder(" + (count + 1) + ")-------\n" + mainCource_oder + "\t$" + mainCource_price + "\n" + drink_oder
              + "\t$" + drink_price + "\n" + snack_oder + "\t$" + snack_price + "\n---------------------\n" + "\t\t$"
              + (drink_price + mainCource_price + snack_price));
      System.out.println("");

      while (true) {
        System.out.print("Would you confirm your oder? (1)Yes (2)Again (3)Back :");
        choose = s.nextInt();
        System.out.println("");
        if (choose == 1) {
          totalOrder[count][0] = mainCource_oder;
          totalOrder[count][1] = String.valueOf(mainCource_price);
          totalOrder[count][2] = drink_oder;
          totalOrder[count][3] = String.valueOf(drink_price);
          totalOrder[count][4] = snack_oder;
          totalOrder[count][5] = String.valueOf(snack_price);
          totalPrice[count] = mainCource_price + drink_price + snack_price;
          count++;
          break;
        } else if (choose == 2) {
          break;
        } else if (choose == 3) {
          return totalPrice;
        }
      }
      while (choose == 1 || choose == 0) {
        System.out.print("Would you oder again? (1)Yes (2)No (0)Same Oder : ");
        choose = s.nextInt();
        System.out.println("");
        if (choose == 1) {
          break;
        } else if (choose == 2) {
          return totalPrice;
        } else if (choose == 0) {
          totalOrder[count][0] = mainCource_oder;
          totalOrder[count][1] = String.valueOf(mainCource_price);
          totalOrder[count][2] = drink_oder;
          totalOrder[count][3] = String.valueOf(drink_price);
          totalOrder[count][4] = snack_oder;
          totalOrder[count][5] = String.valueOf(snack_price);
          totalPrice[count] = mainCource_price + drink_price + snack_price;
          System.out.println(
              "------Oder(" + (count + 1) + ")-------\n" + mainCource_oder + "\t$" + mainCource_price + "\n"
                  + drink_oder
                  + "\t$" + drink_price + "\n" + snack_oder + "\t$" + snack_price + "\n---------------------\n"
                  + "\t\t$"
                  + (drink_price + mainCource_price + snack_price));
          System.out.println("");
          count++;
        }
      }
    }
  }

  /*--------------------------------------------- Basket---------------------------------------------*/

  public static double[] Basket(double totalPrice[]) {
    while (true) {
      System.out.println("-------------------Basket------------------\n\n");
      for (int i = 0; i < totalOrder.length; i++) {
        if (totalOrder[i][0] != null) {
          System.out.println("---------------Order(" + (i + 1) + ")---------------");
        }
        for (int j = 0; j <= 5; j++) {
          if (totalOrder[i][j] != null) {
            if (j % 2 == 0) {
              System.out.print(totalOrder[i][j]);
            } else if (j % 2 == 1) {
              System.out.println("\t\t$" + totalOrder[i][j]);
            }
          }
        }
        if (totalPrice[i] != 0) {
          System.out.println("--------------------------------------\n" + "\t\t\t$" + totalPrice[i]);
          System.out.println("");
        }
      }

      double total = 0;// 支付金額
      for (int i = 0; i < totalPrice.length; i++) {
        total += totalPrice[i];
      }
      System.out
          .println("-------------------------------------------\n" + "Total Amount:" + "\t\t$" + df1.format(total));
      System.out.println("");

      while (true) {
        for (int i = 0; i < basket.length; i++) {
          System.out.print("(" + (i + 1) + ")" + basket[i] + "   ");
        }
        System.out.println("\n");
        System.out.print("(1)-" + "(" + (basket.length) + ")" + ": ");
        choose = s.nextInt();
        System.out.println("");

        if (choose == 1) {
          if (count > 0) {
            while (true) {
              System.out.print("Please enter the oder number[(0)Back!]: ");
              System.out.print("(1)-" + "(" + (count) + ")" + ": ");
              choose = s.nextInt();
              System.out.println("");
              if (choose == 0) {
                break;
              } else if (choose <= count && choose > 0) {
                for (int i = 0; i <= 5; i++) {
                  totalOrder[choose - 1][i] = null;
                }
                totalPrice[choose - 1] = 0;
                // Array空格處理，把totalOrder和totalPrice的空格處理。
                for (int i = 0; i <= count - 1; i++) {
                  for (int j = 0; j <= 5; j++) {
                    if (totalOrder[i][j] == null) {
                      totalOrder[i][j] = totalOrder[i + 1][j];
                      totalOrder[i + 1][j] = null;
                    }
                  }
                  if (totalPrice[i] == 0) {
                    totalPrice[i] = totalPrice[i + 1];
                    totalPrice[i + 1] = 0;
                  }
                }
                count--; // 刪除了一個訂單，訂單數量-1
                return totalPrice;
              }
            }
          }
        } else if (choose == 2) {
          if (count > 0) {
            totalPrice = CheckOut(totalPrice);
            return totalPrice;
          }
        } else if (choose == 3) {
          return totalPrice;
        }
      }
    }
  }

  /*--------------------------------------------- CheckOut---------------------------------------------*/

  public static double[] CheckOut(double totalPrice[]) {
    while (true) {
      checkmember = CheckMember(member);
      if (checkmember == 0) {
        System.out.println(" Is Member");
        System.out.println("");
        break;
      } else if (checkmember == 1) {
        System.out.println("Is not Member");
        System.out.println("");
        break;
      }
    }
    while (true) {
      System.out.println("----------------Check Out(" + (orderNumber + 1) + ")---------------\n\n");
      for (int i = 0; i < totalOrder.length; i++) {
        if (totalOrder[i][0] != null) {
          System.out.println("---------------Order(" + (i + 1) + ")---------------");
        }
        for (int j = 0; j <= 5; j++) {
          if (totalOrder[i][j] != null) {
            if (j % 2 == 0) {
              System.out.print(totalOrder[i][j]);
            } else if (j % 2 == 1) {
              System.out.println("\t\t$" + totalOrder[i][j]);
            }
          }
        }
        if (totalPrice[i] != 0) {
          System.out.println("--------------------------------------\n" + "\t\t\t$" + totalPrice[i]);
          System.out.println("");
        }
      }
      double total = 0; // 每張單的總金額
      double returnAmount = 0; // 返回金額
      for (int i = 0; i < totalPrice.length; i++) {
        total += totalPrice[i];
      }
      if (checkmember == 0) { // 會員八折
        total = total * 0.8;
        System.out.println("(There is a 20% discount)");
      }
      System.out.println(date.format(D) + " " + time.format(D));
      System.out
          .println("-------------------------------------------\n" + "Payment Amount:" + "\t\t$" + df1.format(total));
      System.out.println("");
      System.out.print("Please enter the amout: ");
      pay = s.nextDouble();
      System.out.println("");
      if (pay < total) {
        System.out.println("Insufficient fund!");
        System.out.println("");
      } else {
        returnAmount = pay - total;
        System.out.println("Return: $" + returnAmount);
        System.out.println("");

        // 儲存每張訂單的資料
        for (int i = 0; i <= orderNumber; i++) {
          record[i] = "";
          for (int j = 0; j <= count - 1; j++) {
            record[i] += "------------------Order(" + (j + 1) + ")-----------------\n";
            for (int k = 0; k <= 5; k++) {
              if (totalOrder[j][k] != null) {
                if (k % 2 == 0) {
                  record[i] += totalOrder[j][k];
                } else if (k % 2 == 1) {
                  record[i] += "\t\t$" + totalOrder[j][k] + "\n";
                }
              }
            }
            record[i] += "-------------------------------------------\n" + "\t\t\t$" + totalPrice[j] + "\n\n";
          }
          if (checkmember == 0) { // 會員八折
            record[i] += "(There is a 20% discount)\n";
          }
          record[i] += date.format(D) + " " + time.format(D) + "\n";// date and time
          record[i] += "-------------------------------------------\n" + "Payment Amount:" + "\t\t$"
              + df1.format(total);
        }
        orderNumber++; // 訂單編號
        turnover += total; // 總營業額
        for (int i = 0; i < totalOrder.length; i++) // 清除訂單內容
        {
          for (int j = 0; j <= 5; j++) {
            totalOrder[i][j] = null;
          }
          totalPrice[i] = 0;
          count = 0;
        }
        return totalPrice;
      }
    }
  }

  /*---------------------------------------------Member---------------------------------------------*/

  public static String[][] Member(String member[][]) {

    while (true) {
      for (int i = 0; i < catalongue.length; i++) {
        System.out.println("(" + (i + 1) + ")" + catalongue[i]);
      }
      System.out.print("(1)-" + "(" + (catalongue.length) + ")" + ": ");
      choose = s.nextInt();
      System.out.println("");
      if (choose == 1) {
        member = DeleteMember(member);
      } else if (choose == 2) {
        checkmember = CheckMember(member);

        if (checkmember == 0) {
          System.out.println(" is Member");
          System.out.println("");
        } else if (checkmember == 1) {
          System.out.println("Is not Member");
          System.out.println("");
        }
      } else if (choose == 3) {
        member = CreateMember(member);
      }

      else if (choose == 4) {
        break;
      }
    }
    return member;
  }

  /*---------------------------------------------CreateMember---------------------------------------------*/

  public static String[][] CreateMember(String[][] member) {
    while (true) {
      System.out.print("Please enter the name[(2)Back!]: ");
      memberName = s.next();
      System.out.println("");
      if (memberName.equals("2")) {
        System.out.println("Thank You!");
        System.out.println("");
        return member;
      } else {
        while (true) {
          memberNumber = NewMember.nextInt(899999) + 100000;
          memberNumberString = String.valueOf(memberNumber);

          for (int i = 0; i < member.length; i++) {
            if (member[i][1] == null) {
              member[i][1] = memberNumberString;
              member[i][0] = memberName;
              System.out.println("Hi " + member[i][0] + "! your member number:" + member[i][1]);
              System.out.println("");
              return member;
            } else {
              continue;
            }
          }
        }
      }
    }
  }

  /*---------------------------------------------CheckMember---------------------------------------------*/

  public static int CheckMember(String member[][]) {

    while (true) {
      System.out.print("Please enter your member number[(2)You are not our member!]: ");
      inputMemberNumber = s.next();
      System.out.println("");
      for (int i = 0; i < member.length; i++) {
        if (inputMemberNumber.equals("2")) {
          isMember = 1;
          return isMember;
        } else if (inputMemberNumber.equals(member[i][1])) {
          System.out.print(member[i][0]);
          isMember = 0;
          return isMember;
        } else {
          isMember = 1;

        }
      }
    }
  }

  /*---------------------------------------------DeleteMember---------------------------------------------*/

  public static String[][] DeleteMember(String member[][]) {
    while (true) {
      System.out.print("Please enter your member number[(2)You are not our member!]: ");
      inputMemberNumber = s.next();
      System.out.println("");
      for (int i = 0; i < member.length; i++) {
        if (inputMemberNumber.equals("2")) {
          return member;
        } else if (inputMemberNumber.equals(member[i][1])) {
          deleteMember = member[i][0];
          member[i][1] = "";
          member[i][0] = "";
          System.out.println(deleteMember + "'s member was Deleted!");
          System.out.println("");
          return member;
        } else {
          continue;
        }
      }
    }
  }
}
