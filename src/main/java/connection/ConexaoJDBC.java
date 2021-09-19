package connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoJDBC {

    public static Properties getProp() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        InputStream file = loader.getResourceAsStream("config.properties");
        props.load(file);
        return props;
    }

    public static java.sql.Connection getConnection() {
        Connection connection = null;

        try {
            Properties prop = getProp();
            String urlDeConexao=prop.getProperty("dados.url");
            String usuario=prop.getProperty("dados.usuario");
            String senha= prop.getProperty("dados.senha");

            connection = DriverManager.getConnection(urlDeConexao, usuario, senha);

            return connection;
        } catch (SQLException | IOException e) {
            System.out.println("Não foi possível conectar ao banco de dados!");
            return null;
        }
    }
}
