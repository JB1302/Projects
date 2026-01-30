//Aqui ira el DTO

export type Product = {
	id: string;
	name: string;
	brand: string;
	price: number; // en colones por ahora
	stock: number;

	//Diferentes Categorias
	category: string;

	//Imagen Opcional+
	imageUrl?: string;
};
