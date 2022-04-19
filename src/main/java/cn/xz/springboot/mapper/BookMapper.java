package cn.xz.springboot.mapper;

import cn.xz.springboot.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper extends BaseMapper<Book> {
}
