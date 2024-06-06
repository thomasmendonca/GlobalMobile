import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globalmobile.R
import com.example.globalmobile.Tilapia

data class Tilapia(val id: String, val status: String)

class TilapiaAdapter(private val tilapias: List<Tilapia>) : RecyclerView.Adapter<TilapiaAdapter.TilapiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TilapiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tilapia, parent, false)
        return TilapiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TilapiaViewHolder, position: Int) {
        val tilapia = tilapias[position]
        holder.tilapiaId.text = "Tilapia ID: ${tilapia.id}"
        holder.tilapiaStatus.text = "Status: ${tilapia.status}"
    }

    override fun getItemCount() = tilapias.size

    class TilapiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tilapiaId: TextView = itemView.findViewById(R.id.tvTilapiaId)
        val tilapiaStatus: TextView = itemView.findViewById(R.id.tvTilapiaStatus)
    }
}
