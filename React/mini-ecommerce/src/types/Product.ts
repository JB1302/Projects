//Aqui ira el DTO

export type Product = {
	id: string;
	name: string;
	brand: string;
	price: number; // en colones por ahora
	stock: number;

	//Diferentes Categorias
	category: "GPU" | "CPU" | "RAM" | "SSD" | "PSU";

	//Imagen Opcional+
	imageUrl?: string;
};
