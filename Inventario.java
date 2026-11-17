 import java.util.ArrayList;

public class Inventario {
    ArrayList<Producto> listaProductos = new ArrayList<>();

    // Registrar o sumar stock si ya existe
    public void registrarProducto(String nombre, int cantidad) {
        Producto encontrado = null;
        for (Producto p : listaProductos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado != null) {
            encontrado.stock += cantidad;
            System.out.println("¡El producto ya existía! Se sumaron " + cantidad + " unidades.");
        } else {
            listaProductos.add(new Producto(nombre, cantidad));
            System.out.println("¡Producto registrado con éxito!");
        }
    }

    // Vender restando stock (devuelve true si se pudo, false si falló)
    public boolean venderProducto(String nombre, int cantidad) {
        Producto encontrado = null;
        for (Producto p : listaProductos) {
            if (p.nombre.equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Error: El producto no existe.");
            return false;
        } else if (encontrado.stock < cantidad) {
            System.out.println("¡No se puede vender! Stock insuficiente (Quedan: " + encontrado.stock + ")");
            return false;
        } else {
            encontrado.stock -= cantidad;
            System.out.println("¡Venta realizada con éxito! Stock restante: " + encontrado.stock);
            return true;
        }
    }

    // Ver inventario completo
    public void mostrarInventario() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (listaProductos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto p : listaProductos) {
                System.out.println("- " + p.nombre + " | Stock: " + p.stock);
            }
        }
    }

    // Ver stock crítico (5 unidades o menos)
    public void mostrarStockCritico() {
        System.out.println("\n--- STOCK CRÍTICO (5 o menos unidades) ---");
        boolean hayCriticos = false;
        for (Producto p : listaProductos) {
            if (p.stock <= 5) {
                System.out.println("- " + p.nombre + " | Stock: " + p.stock + " ¡Reponer urgente!");
                hayCriticos = true;
            }
        }
        if (!hayCriticos) {
            System.out.println("No hay productos en estado crítico.");
        }
    }
}