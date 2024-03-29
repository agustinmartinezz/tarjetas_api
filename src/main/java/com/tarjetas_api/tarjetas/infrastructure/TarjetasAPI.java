package com.tarjetas_api.tarjetas.infrastructure;

import com.tarjetas_api.tarjetas.domain.Banco;
import com.tarjetas_api.tarjetas.domain.ITarjetas;
import com.tarjetas_api.tarjetas.domain.Persona;
import com.tarjetas_api.tarjetas.domain.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarjetas")
public class TarjetasAPI implements ITarjetas {
    @Autowired
    DataSource dataSource;

    @CrossOrigin
    @GetMapping
    public List<Tarjeta> getTarjetas() throws SQLException {
        List<Tarjeta> tarjetas = new ArrayList<>();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT T.TarjetaId, T.TarjetaDiaCierre, T.BancoId, B.BancoNombre, T.PersonaId, P.PersonaNombre, P.PersonaApellido FROM TARJETAS AS T, BANCOS AS B, PERSONAS AS P WHERE T.BancoId = B.BancoId AND T.PersonaId = P.PersonaId");

        while (rs.next()) {
            Tarjeta tarjetaAux = new Tarjeta();

            tarjetaAux.setTarjetaId(rs.getInt("TarjetaId"));
            tarjetaAux.setTarjetaDiaCierre(rs.getInt("TarjetaDiaCierre"));
            Banco banco = new Banco(rs.getInt("BancoId"), rs.getString("BancoNombre"));
            tarjetaAux.setBanco(banco);
            Persona persona = new Persona(rs.getInt("PersonaId"), rs.getString("PersonaNombre"), rs.getString("PersonaApellido"));
            tarjetaAux.setPersona(persona);

            tarjetas.add(tarjetaAux);
        }

        con.close();
        stmt.close();
        rs.close();

        return tarjetas;
    }
}
