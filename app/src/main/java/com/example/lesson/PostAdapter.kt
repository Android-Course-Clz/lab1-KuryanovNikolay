import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson.R
import com.example.lesson.models.Post

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postContent: TextView = itemView.findViewById(R.id.post_content)
        val postDate: TextView = itemView.findViewById(R.id.post_date)
        val postImage: ImageView = itemView.findViewById(R.id.post_image) // Новый ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.postContent.text = post.content
        holder.postDate.text = post.date

        // Загружаем изображение через Glide, если оно есть
        post.imageResId?.let {
            Glide.with(holder.itemView.context)
                .load(it) // Если у вас URL, используйте Glide.load(url)
                .into(holder.postImage)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}
