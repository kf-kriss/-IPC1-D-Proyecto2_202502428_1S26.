/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modulos.Album;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class LogicaCompleta {
    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    
    
    public class Juego {
        String codigo;
        String nombre;
        String genero;
        double precio;
        String plataforma;
        int stock;
        String descripcion;
        Juego siguiente;

        public Juego(String codigo, String nombre, String genero, double precio, String plataforma, int stock, String descripcion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.genero = genero;
            this.precio = precio;
            this.plataforma = plataforma;
            this.stock = stock;
            this.descripcion = descripcion;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return codigo + " | " + nombre + " | " + genero + " | Q" + precio + " | " + plataforma + " | Stock: " + stock;
        }
    }

    public class ItemCarrito {
        Juego juego;
        int cantidad;
        ItemCarrito siguiente;

        public ItemCarrito(Juego juego, int cantidad) {
            this.juego = juego;
            this.cantidad = cantidad;
            this.siguiente = null;
        }

        public double subtotal() {
            return juego.precio * cantidad;
        }

        @Override
        public String toString() {
            return juego.nombre + " | Cantidad: " + cantidad + " | Subtotal: Q" + subtotal();
        }
    }

    public class Compra {
        String fecha;
        String detalle;
        double total;
        Compra siguiente;

        public Compra(String fecha, String detalle, double total) {
            this.fecha = fecha;
            this.detalle = detalle;
            this.total = total;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return fecha + " | " + detalle + " | Total: Q" + total;
        }
    }

    private Juego inicioCatalogo;
    private ItemCarrito inicioCarrito;
    private Compra inicioHistorial;

    public LogicaCompleta() {
        inicioCatalogo = null;
        inicioCarrito = null;
        inicioHistorial = null;
    }

    public void cargarCatalogo(String ruta) {
        inicioCatalogo = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] p = linea.split("\\|");

                if (p.length == 7) {
                    Juego nuevo = new Juego(
                            p[0],
                            p[1],
                            p[2],
                            Double.parseDouble(p[3]),
                            p[4],
                            Integer.parseInt(p[5]),
                            p[6]
                    );

                    if (inicioCatalogo == null) {
                        inicioCatalogo = nuevo;
                    } else {
                        Juego aux = inicioCatalogo;
                        while (aux.siguiente != null) {
                            aux = aux.siguiente;
                        }
                        aux.siguiente = nuevo;
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error al cargar catalogo: " + e.getMessage());
        }
    }

    public String mostrarCatalogo() {
        String texto = "";
        Juego aux = inicioCatalogo;

        while (aux != null) {
            texto += aux.toString() + "\n";
            aux = aux.siguiente;
        }

        return texto;
    }

    public Juego buscarJuegoPorCodigo(String codigo) {
        Juego aux = inicioCatalogo;

        while (aux != null) {
            if (aux.codigo.equalsIgnoreCase(codigo)) {
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }

    public boolean agregarAlCarrito(String codigo, int cantidad) {
        Juego juego = buscarJuegoPorCodigo(codigo);

        if (juego == null || cantidad <= 0) {
            return false;
        }

        ItemCarrito aux = inicioCarrito;

        while (aux != null) {
            if (aux.juego.codigo.equalsIgnoreCase(codigo)) {
                aux.cantidad += cantidad;
                return true;
            }
            aux = aux.siguiente;
        }

        ItemCarrito nuevo = new ItemCarrito(juego, cantidad);

        if (inicioCarrito == null) {
            inicioCarrito = nuevo;
        } else {
            aux = inicioCarrito;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }

        return true;
    }

    public String mostrarCarrito() {
        String texto = "";
        ItemCarrito aux = inicioCarrito;

        if (aux == null) {
            return "Carrito vacío";
        }

        while (aux != null) {
            texto += aux.toString() + "\n";
            aux = aux.siguiente;
        }

        return texto;
    }

    public double totalCarrito() {
        double total = 0;
        ItemCarrito aux = inicioCarrito;

        while (aux != null) {
            total += aux.subtotal();
            aux = aux.siguiente;
        }

        return total;
    }

    public void limpiarCarrito() {
        inicioCarrito = null;
    }

    public boolean confirmarCompra() {
        if (inicioCarrito == null) {
            return false;
        }

        ItemCarrito aux = inicioCarrito;

        while (aux != null) {
            if (aux.cantidad > aux.juego.stock) {
                return false;
            }
            aux = aux.siguiente;
        }

        aux = inicioCarrito;
        String detalle = "";
        double total = 0;

        while (aux != null) {
            aux.juego.stock -= aux.cantidad;
            detalle += aux.juego.nombre + " x" + aux.cantidad + " ; ";
            total += aux.subtotal();
            aux = aux.siguiente;
        }

        Compra nueva = new Compra(LocalDateTime.now().toString(), detalle, total);

        if (inicioHistorial == null) {
            inicioHistorial = nueva;
        } else {
            nueva.siguiente = inicioHistorial;
            inicioHistorial = nueva;
        }

        limpiarCarrito();
        return true;
    }

    public String mostrarHistorial() {
        String texto = "";
        Compra aux = inicioHistorial;

        if (aux == null) {
            return "Sin compras";
        }

        while (aux != null) {
            texto += aux.toString() + "\n";
            aux = aux.siguiente;
        }

        return texto;
    }
    
    
    
    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    
    
    public class Carta {
    public String codigo;
    public String nombre;
    public String tipo;
    public String rareza;
    public int ataque;
    public int defensa;
    public int vida;

    public Carta(String codigo, String nombre, String tipo, String rareza,
                 int ataque, int defensa, int vida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }
}
    
    public class NodoMatriz {
        public Carta dato;
        public NodoMatriz arriba, abajo, izquierda, derecha;

        public NodoMatriz() {
            dato = null;
        }
    }
    
    public NodoMatriz inicio;

    public void crearMatriz(int filas, int columnas) {
        NodoMatriz[][] temp = new NodoMatriz[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                temp[i][j] = new NodoMatriz();
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (i > 0) temp[i][j].arriba = temp[i-1][j];
                if (i < filas-1) temp[i][j].abajo = temp[i+1][j];
                if (j > 0) temp[i][j].izquierda = temp[i][j-1];
                if (j < columnas-1) temp[i][j].derecha = temp[i][j+1];
            }
        }
        inicio = temp[0][0];
    }
    
    public void agregarCarta(Carta nueva) {
        NodoMatriz auxFila = inicio;

        while (auxFila != null) {
            NodoMatriz auxCol = auxFila;
    
            while (auxCol != null) {
                if (auxCol.dato == null) {
                    auxCol.dato = nueva;
                    return;
                }
                auxCol = auxCol.derecha;
            }
            auxFila = auxFila.abajo;
        }
    }
    
    public void intercambiar(NodoMatriz a, NodoMatriz b) {
        Carta temp = a.dato;
        a.dato = b.dato;
        b.dato = temp;
    }
    
    public NodoMatriz buscar(String nombre) {
        NodoMatriz fila = inicio;

        while (fila != null) {
            NodoMatriz col = fila;

            while (col != null) {
                if (col.dato != null && col.dato.nombre.equalsIgnoreCase(nombre)) {
                    return col;
                }
                col = col.derecha;
            }
            fila = fila.abajo;
        }
        return null;
    }
  
    public void guardarAlbum(String ruta) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false));

            NodoMatriz fila = inicio;
            int f = 0;

            while (fila != null) {
                NodoMatriz col = fila;
                int c = 0;

                while (col != null) {
                    if (col.dato != null) {
                        bw.write(
                            f + "|" + c + "|" +
                            col.dato.codigo + "|" +
                            col.dato.nombre + "|" +
                            col.dato.tipo + "|" +
                            col.dato.rareza + "|" +
                            col.dato.ataque + "|" +
                            col.dato.defensa + "|" +
                            col.dato.vida
                        );
                        bw.newLine();
                    }

                    col = col.derecha;
                    c++;
                }
    
                fila = fila.abajo;
                f++;
            }

            bw.close();
            System.out.println("Album guardado correctamente");

        } catch (Exception e) {
            System.out.println("Error al guardar album: " + e.getMessage());
        }
    }
    
    
    public void cargarAlbum(String ruta) {
        try {
            java.io.File archivo = new java.io.File(ruta);

            if (!archivo.exists()) {
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            limpiarAlbum();

            while ((linea = br.readLine()) != null) {
                if (linea.trim().equals("")) {
                    continue;
                }

                String[] p = linea.split("\\|");

                if (p.length == 9) {
                    int fila = Integer.parseInt(p[0]);
                    int columna = Integer.parseInt(p[1]);

                    Carta carta = new Carta(
                        p[2],
                        p[3],
                        p[4],
                        p[5],
                        Integer.parseInt(p[6]),
                        Integer.parseInt(p[7]),
                        Integer.parseInt(p[8])
                    );

                    NodoMatriz nodo = obtenerNodo(fila, columna);
                    if (nodo != null) {
                        nodo.dato = carta;
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error al cargar album: " + e.getMessage());
        }
    }
    
    public NodoMatriz obtenerNodo(int filaBuscada, int columnaBuscada) {
        NodoMatriz fila = inicio;
        int f = 0;

        while (fila != null) {
            NodoMatriz col = fila;
            int c = 0;

            while (col != null) {
                if (f == filaBuscada && c == columnaBuscada) {
                    return col;
                }
                col = col.derecha;
                c++;
            }

            fila = fila.abajo;
            f++;
        }

        return null;
    }
    
   
    public void limpiarAlbum() {
        NodoMatriz fila = inicio;

        while (fila != null) {
            NodoMatriz col = fila;

            while (col != null) {
                col.dato = null;
                col = col.derecha;
            }

            fila = fila.abajo;
        }
    }
    
    
    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    


    public class Torneo {
        public String id;
        public String nombre;
        public String juego;
        public String fecha;
        public String hora;
        public double precio;
        public int tickets;
        public Torneo siguiente;

        public Torneo(String id, String nombre, String juego, String fecha, String hora, double precio, int tickets) {
            this.id = id;
            this.nombre = nombre;
            this.juego = juego;
            this.fecha = fecha;
            this.hora = hora;
            this.precio = precio;
            this.tickets = tickets;
            this.siguiente = null;
        }

        @Override
        public String toString() {
            return id + " | " + nombre + " | " + juego + " | " + fecha + " " + hora +
                   " | Q" + precio + " | Tickets: " + tickets;
        }
    }

    public class ClienteTicket {
        public String nombre;
        public Torneo torneo;

        public ClienteTicket(String nombre, Torneo torneo) {
            this.nombre = nombre;
            this.torneo = torneo;
        }

        @Override
        public String toString() {
            return nombre + " -> " + torneo.nombre;
        }
    }

    public class NodoCola {
        public ClienteTicket dato;
        public NodoCola siguiente;

        public NodoCola(ClienteTicket dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public class ColaTickets {
        public NodoCola frente;
        public NodoCola fin;

        public ColaTickets() {
            frente = null;
            fin = null;
        }
    
        public void encolar(ClienteTicket dato) {
            NodoCola nuevo = new NodoCola(dato);

            if (frente == null) {
                frente = nuevo;
                fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public synchronized ClienteTicket desencolar() {
            if (frente == null) {
                return null;
            }

            ClienteTicket dato = frente.dato;
            frente = frente.siguiente;

            if (frente == null) {
                fin = null;
            }

            return dato;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public String mostrar() {
            String texto = "";
            NodoCola aux = frente;

            if (aux == null) {
                return "Cola vacía";
            }

            while (aux != null) {
                texto += aux.dato.toString() + "\n";
                aux = aux.siguiente;
            }

            return texto;
        }
    
        public int size() {
            int count = 0;
            NodoCola aux = frente;

            while (aux != null) {
                count++;
                aux = aux.siguiente;
            }

        return count;
        }
    }

    public Torneo inicioTorneos = null;
    public ColaTickets colaTickets = new ColaTickets();

    public void cargarTorneos(String ruta) {
        inicioTorneos = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] p = linea.split("\\|");

                if (p.length == 7) {
                    Torneo nuevo = new Torneo(
                        p[0],
                        p[1],
                        p[2],
                        p[3],
                        p[4],
                        Double.parseDouble(p[5]),
                        Integer.parseInt(p[6])
                    );

                    if (inicioTorneos == null) {
                        inicioTorneos = nuevo;
                    } else {
                        Torneo aux = inicioTorneos;
                        while (aux.siguiente != null) {
                            aux = aux.siguiente;
                        }
                        aux.siguiente = nuevo;
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error al cargar torneos: " + e.getMessage());
        }
    }

    public String mostrarTorneos() {
        String texto = "";
        Torneo aux = inicioTorneos;

        if (aux == null) {
            return "No hay torneos cargados";
        }

        while (aux != null) {
            texto += aux.toString() + "\n";
            aux = aux.siguiente;
        }

        return texto;
    }

    public Torneo buscarTorneo(String id) {
        Torneo aux = inicioTorneos;

        while (aux != null) {
            if (aux.id.equalsIgnoreCase(id)) {
                return aux;
            }
            aux = aux.siguiente;
        }

        return null;
    }


    public boolean inscribirCliente(String nombre, String idTorneo) {
        Torneo torneo = buscarTorneo(idTorneo);

        if (torneo == null || nombre.trim().equals("")) {
            return false;
        }

        if (torneo.tickets <= 0) {
            return false;
        }

        ClienteTicket cliente = new ClienteTicket(nombre, torneo);
        colaTickets.encolar(cliente);
        return true;
    }

    public void guardarTicketVendido(String ruta, ClienteTicket cliente, String taquilla) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));

            bw.write(
                LocalDateTime.now().toString() + "|" +
                taquilla + "|" +
                cliente.nombre + "|" +
                cliente.torneo.id + "|" +
                cliente.torneo.nombre + "|" +
                cliente.torneo.precio
            );

            bw.newLine();
            bw.close();

        } catch (Exception e) {
            System.out.println("Error al guardar ticket: " + e.getMessage());
        }
    }



    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------

public interface Guardable {
    void guardar(String ruta);
}

public abstract class Recompensa {
    public abstract int obtenerXP();
}

public class RecompensaCompra extends Recompensa {
    public int obtenerXP() {
        return 50;
    }
}

public class RecompensaEvento extends Recompensa {
    public int obtenerXP() {
        return 150;
    }
}

public class RecompensaAlbum extends Recompensa {
    public int obtenerXP() {
        return 20;
    }
}

public int xpUsuario = 0;

public void aplicarRecompensa(Recompensa r) {
    xpUsuario += r.obtenerXP();
}

public int obtenerNivel() {
    if (xpUsuario >= 7000) return 5;
    if (xpUsuario >= 3500) return 4;
    if (xpUsuario >= 1500) return 3;
    if (xpUsuario >= 500) return 2;
    return 1;
}

public String obtenerRango() {
    int nivel = obtenerNivel();

    if (nivel == 5) return "Leyenda";
    if (nivel == 4) return "Maestro";
    if (nivel == 3) return "Veterano";
    if (nivel == 2) return "Jugador";
    return "Aprendiz";
}

public int obtenerXPMin() {
    int n = obtenerNivel();

    if (n == 5) return 7000;
    if (n == 4) return 3500;
    if (n == 3) return 1500;
    if (n == 2) return 500;
    return 0;
}

public int obtenerXPMax() {
    int n = obtenerNivel();

    if (n == 1) return 500;
    if (n == 2) return 1500;
    if (n == 3) return 3500;
    if (n == 4) return 7000;
    return 7000;
}

public int progresoNivel() {
    if (obtenerNivel() == 5) return 100;

    int min = obtenerXPMin();
    int max = obtenerXPMax();

    return (xpUsuario - min) * 100 / (max - min);
}

public String mostrarLogros() {
    String t = "";

    t += xpUsuario >= 50 ? "✔ Primera compra\n" : "✘ Primera compra\n";
    t += xpUsuario >= 200 ? "✔ Primer avance\n" : "✘ Primer avance\n";
    t += xpUsuario >= 500 ? "✔ Jugador\n" : "✘ Jugador\n";
    t += xpUsuario >= 1000 ? "✔ Gamer dedicado\n" : "✘ Gamer dedicado\n";
    t += xpUsuario >= 1500 ? "✔ Veterano\n" : "✘ Veterano\n";
    t += xpUsuario >= 2000 ? "✔ Gran gastador\n" : "✘ Gran gastador\n";
    t += xpUsuario >= 3500 ? "✔ Maestro\n" : "✘ Maestro\n";
    t += xpUsuario >= 7000 ? "✔ Leyenda\n" : "✘ Leyenda\n";

    return t;
}

public class NodoUsuario {
    public String nombre;
    public int xp;
    public NodoUsuario sig;

    public NodoUsuario(String n, int x) {
        nombre = n;
        xp = x;
        sig = null;
    }
}

public NodoUsuario crearListaUsuarios() {
    NodoUsuario a = new NodoUsuario("Carlos", xpUsuario);
    a.sig = new NodoUsuario("Ana", 1200);
    a.sig.sig = new NodoUsuario("Luis", 800);
    a.sig.sig.sig = new NodoUsuario("Mario", 3000);
    a.sig.sig.sig.sig = new NodoUsuario("Sofia", 5000);

    return a;
}

public NodoUsuario ordenarUsuarios(NodoUsuario head) {
    if (head == null) return null;

    boolean cambio;
    do {
        cambio = false;
        NodoUsuario aux = head;

        while (aux.sig != null) {
            if (aux.xp < aux.sig.xp) {
                int tx = aux.xp;
                String tn = aux.nombre;

                aux.xp = aux.sig.xp;
                aux.nombre = aux.sig.nombre;

                aux.sig.xp = tx;
                aux.sig.nombre = tn;

                cambio = true;
            }
            aux = aux.sig;
        }

    } while (cambio);

    return head;
}

public String mostrarLeaderboard() {
    NodoUsuario lista = ordenarUsuarios(crearListaUsuarios());

    String t = "";
    int pos = 1;

    while (lista != null) {
        t += pos + ". " + lista.nombre + " - " + lista.xp + " XP\n";
        lista = lista.sig;
        pos++;
    }

    return t;
}



    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------



    public String fechaReporte() {
        java.time.LocalDateTime ahora = java.time.LocalDateTime.now();

        return ahora.getDayOfMonth() + "_" +
               ahora.getMonthValue() + "_" +
               ahora.getYear() + "_" +
               ahora.getHour() + "_" +
               ahora.getMinute() + "_" +
               ahora.getSecond();
    }

    public void reporteInventario() {
        try {
            String nombre = fechaReporte() + "_Inventario.html";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            bw.write("<html>");
            bw.write("<head><title>Reporte Inventario</title></head>");
            bw.write("<body>");

            bw.write("<h1>Reporte de Inventario</h1>");

            bw.write("<table border='1'>");
            bw.write("<tr>");
            bw.write("<th>Código</th>");
            bw.write("<th>Nombre</th>");
            bw.write("<th>Género</th>");
            bw.write("<th>Precio</th>");
            bw.write("<th>Plataforma</th>");
            bw.write("<th>Stock</th>");
            bw.write("</tr>");

            Juego aux = inicioCatalogo;

            while (aux != null) {
                bw.write("<tr>");
                bw.write("<td>" + aux.codigo + "</td>");
                bw.write("<td>" + aux.nombre + "</td>");
                bw.write("<td>" + aux.genero + "</td>");
                bw.write("<td>" + aux.precio + "</td>");
                bw.write("<td>" + aux.plataforma + "</td>");
                bw.write("<td>" + aux.stock + "</td>");
                bw.write("</tr>");

                aux = aux.siguiente;
            }

            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");
    
            bw.close();

            abrirHTML(nombre);

        } catch (Exception e) {
            System.out.println("Error reporte inventario: " + e.getMessage());
        }
    }

    public void reporteAlbum() {
        try {

            crearMatriz(4, 6);

            cargarAlbum("album.txt");

            String nombre = fechaReporte() + "_Album.html";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            bw.write("<html>");
            bw.write("<head><title>Reporte Album</title></head>");
            bw.write("<body>");

            bw.write("<h1>Reporte del Álbum</h1>");

            bw.write("<table border='1'>");

            NodoMatriz fila = inicio;

            while (fila != null) {
                bw.write("<tr>");
                NodoMatriz col = fila;

                while (col != null) {

                    if (col.dato == null) {
                        bw.write("<td>Vacía</td>");
                    } else {
                        bw.write("<td>");
                        bw.write(col.dato.nombre + "<br>");
                        bw.write(col.dato.tipo + "<br>");
                        bw.write(col.dato.rareza);
                        bw.write("</td>");
                    }

                    col = col.derecha;
                }

                bw.write("</tr>");
                fila = fila.abajo;
            }

            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");

            bw.close();

            abrirHTML(nombre);

        } catch (Exception e) {
            System.out.println("Error reporte album: " + e.getMessage());
        }
    }

    public void reporteTorneos() {
        try {
        
            cargarTorneos("torneos.txt");

            String nombre = fechaReporte() + "_Torneos.html";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            bw.write("<html>");
            bw.write("<head><title>Reporte Torneos</title></head>");
            bw.write("<body>");

            bw.write("<h1>Reporte de Torneos</h1>");

            bw.write("<table border='1'>");
            bw.write("<tr>");
            bw.write("<th>ID</th>");
            bw.write("<th>Nombre</th>");
            bw.write("<th>Juego</th>");
            bw.write("<th>Fecha</th>");
            bw.write("<th>Hora</th>");
            bw.write("<th>Precio</th>");
            bw.write("<th>Tickets</th>");
            bw.write("</tr>");

            Torneo aux = inicioTorneos;

            while (aux != null) {
                bw.write("<tr>");
                bw.write("<td>" + aux.id + "</td>");
                bw.write("<td>" + aux.nombre + "</td>");
                bw.write("<td>" + aux.juego + "</td>");
                bw.write("<td>" + aux.fecha + "</td>");
                bw.write("<td>" + aux.hora + "</td>");
                bw.write("<td>" + aux.precio + "</td>");
                bw.write("<td>" + aux.tickets + "</td>");
                bw.write("</tr>");

                aux = aux.siguiente;
            }

            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");

            bw.close();

            abrirHTML(nombre);

        } catch (Exception e) {
            System.out.println("Error reporte torneos: " + e.getMessage());
        }
    }

    public void reporteVentas() {
        try {
            String nombre = fechaReporte() + "_Ventas.html";
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombre));

            bw.write("<html>");
            bw.write("<head><title>Reporte Ventas</title></head>");
            bw.write("<body>");

            bw.write("<h1>Reporte de Ventas</h1>");

            bw.write("<table border='1'>");
            bw.write("<tr>");
            bw.write("<th>Fecha</th>");
            bw.write("<th>Detalle</th>");
            bw.write("<th>Total</th>");
            bw.write("</tr>");

            Compra aux = inicioHistorial;

            while (aux != null) {
                bw.write("<tr>");
                bw.write("<td>" + aux.fecha + "</td>");
                bw.write("<td>" + aux.detalle + "</td>");
                bw.write("<td>" + aux.total + "</td>");
                bw.write("</tr>");

                aux = aux.siguiente;
            }

            bw.write("</table>");
            bw.write("</body>");
            bw.write("</html>");

            bw.close();

            abrirHTML(nombre);

        } catch (Exception e) {
            System.out.println("Error reporte ventas: " + e.getMessage());
        }
    }
    

    public void abrirHTML(String archivo) {
        try {
            java.io.File f = new java.io.File(archivo);
            java.awt.Desktop.getDesktop().browse(f.toURI());
        } catch (Exception e) {
            System.out.println("No se pudo abrir reporte: " + e.getMessage());
        }
    }

    
    
    
    
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    
    
    
    
}
