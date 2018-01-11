package M02_Home;

import edu.ucab.desarrollo.viucab.dataAccessLayer.Dao;
import edu.ucab.desarrollo.viucab.webService.M02_Home.M02_Home;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

class M02_HomeWS {

  /*  Dao _dao;
    ResultSet rs;
    //   CreateUserCommand
    @Before
    public void setUp() throws Exception {
        Connection conn = _dao.getConInstance();
        String insertUserQuery ="SELECT M01_REGISTRAR('"+"danri"+"','"+"dan1234"+"','"+"dan"+"','"+'F'+"'" +
                ",'"+"dan"+"','"+"1993-06-11"+"','"+1.0+"','"+1.0+"')";
        try {
              // rs =conn.sql(insertUserQuery);
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }

    @Test
    void obtenerPreferencia() {

        Connection conn = _dao.getConInstance();

        URI prueba = new URI("http://localhost:8888/WebServicesFitUCAB_war_exploded/M01_ServicesUser/informationUser?username=danri");
        given().accept(ContentType.JSON).when().get(prueba).then()
                .assertThat().statusCode(HttpStatus.SC_OK);
        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);

    }

    @Test
    void obtenerMasVistos() {
    }

    @Test
    void obtenerVideosSuscritos() {
    }

    @Test
    void busquedaVideos() {
    }

    @Test
    void obtenerVideosInicio() {
    }*/
}