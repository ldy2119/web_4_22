package kr.hs.dgsw.web02blog.Service;

import kr.hs.dgsw.web02blog.Protocol.PostUserNameProtocol;
import kr.hs.dgsw.web02blog.Repository.PostRepository;
import kr.hs.dgsw.web02blog.Repository.UserRepository;
import kr.hs.dgsw.web02blog.domain.Post;
import kr.hs.dgsw.web02blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init()
    {
        postRepository.save(new Post("11", "국민의 모든 자유와 권리는 국가안전보장·질서유지 또는 공공복리를 위하여 필요한 경우에 한하여 법률로써 제한할 수 있으며, 제한하는 경우에도 자유와 권리의 본질적인 내용을 침해할 수 없다.\n" +
                "\n" +
                "누구든지 병역의무의 이행으로 인하여 불이익한 처우를 받지 아니한다. 제안된 헌법개정안은 대통령이 20일 이상의 기간 이를 공고하여야 한다. 국회는 헌법개정안이 공고된 날로부터 60일 이내에 의결하여야 하며, 국회의 의결은 재적의원 3분의 2 이상의 찬성을 얻어야 한다.\n" +
                "\n" +
                "피고인의 자백이 고문·폭행·협박·구속의 부당한 장기화 또는 기망 기타의 방법에 의하여 자의로 진술된 것이 아니라고 인정될 때 또는 정식재판에 있어서 피고인의 자백이 그에게 불리한 유일한 증거일 때에는 이를 유죄의 증거로 삼거나 이를 이유로 처벌할 수 없다.\n" +
                "\n" +
                "이 헌법공포 당시의 국회의원의 임기는 제1항에 의한 국회의 최초의 집회일 전일까지로 한다. 공무원인 근로자는 법률이 정하는 자에 한하여 단결권·단체교섭권 및 단체행동권을 가진다.\n" +
                "\n" +
                "탄핵결정은 공직으로부터 파면함에 그친다. 그러나, 이에 의하여 민사상이나 형사상의 책임이 면제되지는 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에 필요한 서류의 제출 또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.\n" +
                "\n" +
                "국회의원의 선거구와 비례대표제 기타 선거에 관한 사항은 법률로 정한다. 재의의 요구가 있을 때에는 국회는 재의에 붙이고, 재적의원과반수의 출석과 출석의원 3분의 2 이상의 찬성으로 전과 같은 의결을 하면 그 법률안은 법률로서 확정된다.\n" +
                "\n" +
                "헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다. 헌법재판소에서 법률의 위헌결정, 탄핵의 결정, 정당해산의 결정 또는 헌법소원에 관한 인용결정을 할 때에는 재판관 6인 이상의 찬성이 있어야 한다.\n" +
                "\n" +
                "감사원은 세입·세출의 결산을 매년 검사하여 대통령과 차년도국회에 그 결과를 보고하여야 한다. 대통령이 임시회의 집회를 요구할 때에는 기간과 집회요구의 이유를 명시하여야 한다.\n" +
                "\n" +
                "대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다. 국회의원은 그 지위를 남용하여 국가·공공단체 또는 기업체와의 계약이나 그 처분에 의하여 재산상의 권리·이익 또는 직위를 취득하거나 타인을 위하여 그 취득을 알선할 수 없다.\n" +
                "\n" +
                "누구든지 체포 또는 구속을 당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 국무위원은 국무총리의 제청으로 대통령이 임명한다. 대통령은 법률이 정하는 바에 의하여 사면·감형 또는 복권을 명할 수 있다.\n" +
                "\n" +
                "국회의원의 수는 법률로 정하되, 200인 이상으로 한다. 중앙선거관리위원회는 대통령이 임명하는 3인, 국회에서 선출하는 3인과 대법원장이 지명하는 3인의 위원으로 구성한다. 위원장은 위원중에서 호선한다.\n" +
                "\n" +
                "대통령은 국무회의의 의장이 되고, 국무총리는 부의장이 된다. 대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다. 대법원장과 대법관이 아닌 법관은 대법관회의의 동의를 얻어 대법원장이 임명한다.\n" +
                "\n" +
                "모든 국민은 신체의 자유를 가진다. 누구든지 법률에 의하지 아니하고는 체포·구속·압수·수색 또는 심문을 받지 아니하며, 법률과 적법한 절차에 의하지 아니하고는 처벌·보안처분 또는 강제노역을 받지 아니한다.\n" +
                "\n" +
                "국교는 인정되지 아니하며, 종교와 정치는 분리된다. 위원은 정당에 가입하거나 정치에 관여할 수 없다. 국가안전보장회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다.\n" +
                "\n" +
                "법률은 특별한 규정이 없는 한 공포한 날로부터 20일을 경과함으로써 효력을 발생한다. 국무총리·국무위원 또는 정부위원은 국회나 그 위원회에 출석하여 국정처리상황을 보고하거나 의견을 진술하고 질문에 응답할 수 있다.\n" +
                "\n" +
                "국가는 균형있는 국민경제의 성장 및 안정과 적정한 소득의 분배를 유지하고, 시장의 지배와 경제력의 남용을 방지하며, 경제주체간의 조화를 통한 경제의 민주화를 위하여 경제에 관한 규제와 조정을 할 수 있다.\n" +
                "\n" +
                "이 헌법시행 당시의 법령과 조약은 이 헌법에 위배되지 아니하는 한 그 효력을 지속한다. 이 헌법중 공무원의 임기 또는 중임제한에 관한 규정은 이 헌법에 의하여 그 공무원이 최초로 선출 또는 임명된 때로부터 적용한다.\n" +
                "\n" +
                "국가는 전통문화의 계승·발전과 민족문화의 창달에 노력하여야 한다. 타인의 범죄행위로 인하여 생명·신체에 대한 피해를 받은 국민은 법률이 정하는 바에 의하여 국가로부터 구조를 받을 수 있다.\n" +
                "\n" +
                "지방자치단체는 주민의 복리에 관한 사무를 처리하고 재산을 관리하며, 법령의 범위안에서 자치에 관한 규정을 제정할 수 있다. 모든 국민은 법률이 정하는 바에 의하여 납세의 의무를 진다.\n" +
                "\n" +
                "국가는 대외무역을 육성하며, 이를 규제·조정할 수 있다. 모든 국민은 인간으로서의 존엄과 가치를 가지며, 행복을 추구할 권리를 가진다. 국가는 개인이 가지는 불가침의 기본적 인권을 확인하고 이를 보장할 의무를 진다.", 1L));
        postRepository.save(new Post("33", "44", 1L));
    }

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public PostUserNameProtocol readPost(Long id) {
        return postRepository.findById(id).map(f ->
        {
            return new PostUserNameProtocol(f, userRepository.findById(f.getUserId()).orElse(null).getName());
        }).orElse(null);
    }

    @Override
    public PostUserNameProtocol get(Long userId)
    {
        return postRepository.findTopByUserIdOrderByIdDesc(userId).map(f ->
        {
            return new PostUserNameProtocol(f, userRepository.findById(f.getUserId()).orElse(null).getName());
        }).orElse(null);
    }

    @Override
    public List<PostUserNameProtocol> list()
    {
        List<Post> postList;
        List<PostUserNameProtocol> postPtcl = new ArrayList<>();
        postList = postRepository.findAll();

        for(int i = 0; i < postList.size(); i++)
        {
            Optional<User> user = userRepository.findById(postList.get(i).getUserId());
            String userName = user.isPresent() ? user.get().getName() : null;
            postPtcl.add(new PostUserNameProtocol(postList.get(i), userName));
        }
        return postPtcl;
    }

    @Override
    public Post updatePost(Post post) {
        try
        {
            return postRepository.findById(post.getId()).map(f ->
            {
                f.setContent(post.getContent());
                f.setTitle(post.getTitle());
                f.getPictures().clear();
                f.setPictures(post.getPictures());
                return postRepository.save(f);
            }).orElse(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deletePost(Long id) {
        return postRepository.findById(id).map(f ->
        {
            postRepository.delete(f);
            return true;
        }).orElse(false);
    }
}
