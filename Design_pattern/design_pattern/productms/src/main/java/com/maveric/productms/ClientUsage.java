package com.maveric.productms;


/*public class ClientUsage {
    public static void main(String[] args) {
        IOldProductService oldService=new OldProductServiceImpl();
        OldClient oldClient=new OldClient(oldService);
        System.out.println("display all products");
        oldClient.displayAllProducts();
        System.out.println("display product by id");
        oldClient.displayProductById(1);
    }
}*/


public class ClientUsage {
    public static void main(String[] args) {
        IOldProductService oldService = new OldProductServiceImpl();
        OldClient oldClient = new OldClient(oldService);
        System.out.println("Old Client - display all products");
        oldClient.displayAllProducts();
        System.out.println("Old Client - display product by id");
        oldClient.displayProductById(1);

        INewProductService newService = new OldToNewServiceAdapter(oldService);
        NewClient newClient = new NewClient(newService);
        System.out.println("New Client - display all products");
        newClient.displayAllProducts();
        System.out.println("New Client - display product by id");
        newClient.displayProductById(1);
    }
}