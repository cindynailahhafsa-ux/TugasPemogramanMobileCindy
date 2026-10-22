class StudentCard(
    val nim: String,
    var nama: String,
    val prodi: String
) {
    var totalSks: Int = 0
        private set

    val status: String
        get() = if (totalSks > 0) "Aktif" else "Baru"

    init {
        require(nim.length >= 7) { "NIM tidak valid" }
    }

    fun ambilSks(jumlah: Int) {
        if (jumlah > 0 && totalSks + jumlah <= 22) {
            totalSks += jumlah
        }
    }

    fun ringkasan() =
        "$nim · $nama · $prodi · $totalSks SKS"
}

fun main() {
    // Bikin object (data benar)
    val mahasiswa = StudentCard("2409020045", "Cindy", "Teknologi Informasi")

    // Ubah SKS jadi 24
    mahasiswa.ambilSks(22)

    // Nampilin hasilnya
    println(mahasiswa.ringkasan())
    println("Status: ${mahasiswa.status}")

    // val error = StudentCard("421", "ika", "Data science")
}