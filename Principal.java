import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Inventario miBodega = new Inventario();
            int opcion = 0;
            
            // Datos iniciales de prueba
            miBodega.registrarProducto("Bebida 3L", 10);
            miBodega.registrarProducto("Arroz", 3);
            
            do {
                System.out.println("\n--- MENÚ ALMACÉN ---");
                System.out.println("1. Registrar / Sumar Stock");
                System.out.println("2. Vender (Restar Stock)");
                System.out.println("3. Ver Inventario Total");
                System.out.println("4. Ver Stock Crítico (<= 5)");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el ENTER
                    
                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Nombre del producto: ");
                            String nombreReg = scanner.nextLine();
                            System.out.print("Cantidad: ");
                            int cantReg = scanner.nextInt();
                            scanner.nextLine();
                            miBodega.registrarProducto(nombreReg, cantReg);
                        }
                        case 2 -> {
                            System.out.print("Nombre del producto a vender: ");
                            String nombreVenta = scanner.nextLine();
                            System.out.print("Cantidad a vender: ");
                            int cantVenta = scanner.nextInt();
                            scanner.nextLine();
                            miBodega.venderProducto(nombreVenta, cantVenta);
                        }
                        case 3 -> miBodega.mostrarInventario();
                        case 4 -> miBodega.mostrarStockCritico();
                        case 5 -> System.out.println("Saliendo del sistema...");
                        default -> System.out.println("Opción inválida.");
                    }
                } else {
                    System.out.println("Por favor, ingresa un número válido.");
                    scanner.next();
                }
                
            } while (opcion != 5);
        }
    }
}
