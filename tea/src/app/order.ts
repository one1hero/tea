export class Order {
    id: number;
    drink: string;
    cuptype: string;
    sweet: string;
    temperature: string;
    ingredients: Array<string> = new Array();
}
