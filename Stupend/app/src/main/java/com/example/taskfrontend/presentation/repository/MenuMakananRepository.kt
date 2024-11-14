package com.example.taskfrontend.presentation.repository

import com.example.taskfrontend.presentation.model.Menu_Makanan

class MenuMakananRepository {
    private val menuMakanan  = listOf(
        Menu_Makanan(1, "https://tse1.mm.bing.net/th?id=OIP.VunU9XqQtNnRJCAlU-G9MAHaE7&pid=Api&P=0&h=220", "Burger", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 15000.00, "Burger Heaven", 4.5),
        Menu_Makanan(2, "https://tse2.mm.bing.net/th?id=OIP.ildCrKedl5wZSDvDouexMQHaEo&pid=Api&P=0&h=220", "Pizza", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 50000.00, "Pizza Heaven", 4.7),
        Menu_Makanan(3, "https://tse4.mm.bing.net/th?id=OIP.vvaZ2m82cWsC2pmBryEyggHaE7&pid=Api&P=0&h=220", "Sushi", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 45000.00, "Sushi Heaven", 4.3),
        Menu_Makanan(4, "https://tse4.mm.bing.net/th?id=OIP.fNPoJ7e5qh_A5Lh8iDyFVgHaE8&pid=Api&P=0&h=220", "Spaghetti", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 60000.00, "Spaghetti Heaven", 4.6),
        Menu_Makanan(5, "https://4.bp.blogspot.com/-hTxkFox1ee4/WSOZSYYdgYI/AAAAAAAAAKA/JiCfAjNLJms0lNvf2VlWkuKr7aH_fCVKgCLcB/s1600/resep-dan-cara-membuat-donat-kentang-1.jpg", "Donat", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 30000.00, "Donat Heaven", 5.0),
        Menu_Makanan(6, "https://tse3.mm.bing.net/th?id=OIP.zFqsnafhHi_HTg66xfn-wQHaFj&pid=Api&P=0&h=220", "Salad", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 20000.00, "Salad Heaven", 4.8),
        Menu_Makanan(7, "https://wallpaperaccess.com/full/1462899.jpg", "Steak", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 55000.00, "Steak Heaven", 4.9),
        Menu_Makanan(8, "https://superapp.id/blog/wp-content/uploads/2020/10/6-47-1170x690.jpg", "Kebab", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 15000.00, "Kebab Heaven", 4.5),
        Menu_Makanan(9, "https://asset.kompas.com/crops/DEDxeclyBPPZ2miRZhxGFJxhHU0=/0x175:800x708/750x500/data/photo/2021/01/18/60053789dc100.jpg", "Dim Sum", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 25000.00, "Dim Sum Heaven", 4.8),
        Menu_Makanan(10, "https://tse1.mm.bing.net/th?id=OIP.uHtWeoRs2RLAjrM1YwJiCQHaEK&pid=Api&P=0&h=220", "Churros", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.", 45000.00, "Churros Heaven", 4.4),
    )

    fun getMenuMakanan() : List<Menu_Makanan>{
        return menuMakanan
    }
}