// Import untuk Parcelize
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

// Data class Hero yang mengimplementasikan Parcelable
@Parcelize
data class Flower(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
