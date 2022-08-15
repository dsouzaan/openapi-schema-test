package schematest.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-16T06:57:16.050905141+10:00[Australia/Melbourne]")
@Controller
@RequestMapping("${openapi.people.base-path:/api/v1}")
public class PeopleApiController implements PeopleApi {

    private final PeopleApiDelegate delegate;

    public PeopleApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) PeopleApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PeopleApiDelegate() {});
    }

    @Override
    public PeopleApiDelegate getDelegate() {
        return delegate;
    }

}
