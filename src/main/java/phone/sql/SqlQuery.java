package phone.sql;

import phone.gui.Login;
import phone.gui.PhonePanel;
import phone.gui.RegistrationPanel;
import phone.model.User;
import phone.model.UserRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlQuery {
    String query;
    SqlConnection sqlConnection = new SqlConnection();
    UserRepository userRepository = new UserRepository();

    private String findLoginQuery(String userLogin) {
        query = "Select count(*) from [dbo].[TELEFONY_UPRAWNIENIA] where Login= '" + userLogin + "'";
        return query;
    }

    private String addUserQuery(User user) {
        query = "Insert into [dbo].[TELEFONY_UPRAWNIENIA] (Login, [Nazwisko Imie], Imie, Nazwisko) values('" + user.getLogin() + "', '" + user.getSurnameAndName().toUpperCase().trim() + "', '" + user.getName().toUpperCase().trim() + "', '" + user.getSurname().toUpperCase().trim() + "')";
        return query;
    }

    private String addTopicList() {
        query = "SELECT distinct Temat FROM [POZA_ANALIZAMI].[dbo].[TELEFONY_TEMAT_PODKATEGORIA] order by Temat asc";
        return query;
    }

    private String addSubcategoryList(String topic) {
        query = "SELECT distinct Podkategoria FROM [POZA_ANALIZAMI].[dbo].[TELEFONY_TEMAT_PODKATEGORIA] where Temat= '" + topic + "' order by Podkategoria asc ";
        return query;
    }

    public void addSubcategoryListFromDatabase(ArrayList listSubcategory, String topic) {
        try {
            ResultSet resultSet = sqlConnection.connectUpdate().executeQuery(addSubcategoryList(topic));
            while (resultSet.next()) {
                listSubcategory.add(resultSet.getString(1));
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void addTopicListFromDatabase(ArrayList listTopic) {
        try {
            ResultSet resultSet = sqlConnection.connectUpdate().executeQuery(addTopicList());
            while (resultSet.next()) {
                listTopic.add(resultSet.getString(1));
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void isLoginInDatabase(String userLogin, JFrame loginFrame) {

        try {
            findLoginQuery(userLogin);
            ResultSet resultSet = sqlConnection.connectUpdate().executeQuery(query);
            while (resultSet.next()) {
                if (userRepository.findUser(resultSet.getInt(1))) {
                    loginFrame.setVisible(false);
                    PhonePanel phonePanel = new PhonePanel();
                } else {
                    RegistrationPanel registrationPanel = new RegistrationPanel();
                    loginFrame.setVisible(false);
                }
            }
            resultSet.close();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void addUser(User user, JFrame frameMakeInvisible) {
        checkIsUserInDatabase(user, frameMakeInvisible);
        try {
            if (userRepository.isAllFieldInUser(user)) {
                sqlConnection.connectUpdate().executeUpdate(addUserQuery(user));
                JOptionPane.showMessageDialog(null, "Osoba została dodana do bazy",
                        "DODANO", JOptionPane.INFORMATION_MESSAGE);
                frameMakeInvisible.setVisible(false);
                Login login = new Login();

            } else {
                JOptionPane.showMessageDialog(null, "Należy uzupełnić wszystkie wymagane pola",
                        "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void checkIsUserInDatabase(User user, JFrame frameMakeInvisible) {
        findLoginQuery(user.getLogin());
        try {
            ResultSet resultSet = sqlConnection.connectUpdate().executeQuery(query);
            while (resultSet.next()) {
                if (userRepository.findUser(resultSet.getInt(1))) {
                    JOptionPane.showMessageDialog(null, "Użytkownik o podanym loginie istnieje już w bazie",
                            "OSTRZEŻENIE", JOptionPane.WARNING_MESSAGE);
                    frameMakeInvisible.setVisible(false);
                    resultSet.close();
                    System.exit(1);
                }
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}