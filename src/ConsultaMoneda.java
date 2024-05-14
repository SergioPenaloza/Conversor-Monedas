import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public void conversionMoneda(String monedaBase, String monedaDestino, float cantidadDinero){
        String direccion = "https://v6.exchangerate-api.com/v6/1d493a12419aa77daaf162fa/pair/" + monedaBase +"/" +
                monedaDestino + "/" + cantidadDinero;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            System.out.println("El valor " + cantidadDinero + " [" + monedaBase + "] corresponde al valor final de =>>> " +
                    moneda.toString() + " [" + monedaDestino + "]");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversión de moneda"+e.getMessage());
        }
    }

}
