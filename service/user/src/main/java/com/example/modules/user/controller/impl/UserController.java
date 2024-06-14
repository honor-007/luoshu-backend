package com.example.modules.user.controller.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.core.secure.entity.AuthInfo;
import com.example.core.secure.entity.SecureUser;
import com.example.core.secure.utils.SecureUtil;
import com.example.core.tool.api.R;
import com.example.core.tool.utils.Func;
import com.example.core.tool.utils.RedisUtils;
import com.example.modules.user.controller.vo.UserVO;
import com.example.modules.user.dao.criteria.UserCriteria;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.service.impl.UserService;
import com.example.modules.user.support.UserConvertMapper;
import com.example.modules.user.support.UserWrapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author honor
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@OpenAPIDefinition(info = @Info(title = "用户模块", description = "对用户进行操作", version = "1.0.0"))
@Tag(name = "user")
public class UserController {
    private final UserService userService;
    private final RedisUtils redisUtils;

    /**
     * 用户列表
     */
    @Operation(summary = "user分页list")
    @GetMapping("/page")
    public R<IPage<UserVO>> list(UserCriteria criteria) {
        IPage<User> pages = userService.page(criteria);
        return R.data(UserWrapper.build().pageVO(pages));
    }

    /**
     * 查询单条
     */
    @Operation(summary = "查看详情")
    @GetMapping("/detail")
    public R<UserVO> detail(User user) {
        User detail = userService.getOne(user);
        return R.data(UserConvertMapper.INSTANT.from(detail));
    }


    /**
     * 查询挡墙用户信息
     */
    @Operation(summary = "获取当前登录的用户信息")
    @GetMapping("/currentUser")
    public R<AuthInfo> info() {
        SecureUser secureUser = SecureUtil.getUser();
        AuthInfo authInfo = userService.getCurrentUser(secureUser.getId());
        return R.data(authInfo);
    }

//    @Operation(summary = "账号密码登录")
//    @GetMapping("/signByPassword")
//    public R<UserVO> signByPassword() {
//        UserInfo userInfo = userService.signByPassword("rongyu", "123456", "000000");
//        return R.success("rongyu");
//    }

    /**
     * 新增或修改
     */
    @PostMapping("/submit")
    public R saveOrUpdate(@Valid @RequestBody User user) {
        return R.status(userService.saveOrUpdate(user));
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@Valid @RequestBody User user) {
        return R.status(userService.updateById(user));
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public R remove(@RequestParam String ids) {
        return R.status(userService.deleteBatchByIds(Func.toLongList(ids)));
    }
//
//
//    /**
//     * 设置菜单权限
//     *
//     * @param userIds
//     * @param roleIds
//     * @return
//     */
//    @PostMapping("/grant")
//    @ApiOperationSupport(order = 7)
//    @ApiOperation(value = "权限设置", notes = "传入roleId集合以及menuId集合")
//    public R grant(@ApiParam(value = "userId集合", required = true) @RequestParam String userIds,
//                   @ApiParam(value = "roleId集合", required = true) @RequestParam String roleIds) {
//        boolean temp = userService.grant(userIds, roleIds);
//        return R.status(temp);
//    }
//
//    @PostMapping("/reset-password")
//    @ApiOperationSupport(order = 8)
//    @ApiOperation(value = "初始化密码", notes = "传入userId集合")
//    public R resetPassword(@ApiParam(value = "userId集合", required = true) @RequestParam String userIds) {
//        boolean temp = userService.resetPassword(userIds);
//        return R.status(temp);
//    }
//
//    /**
//     * 修改密码
//     *
//     * @param oldPassword
//     * @param newPassword
//     * @param newPassword1
//     * @return
//     */
//    @PostMapping("/update-password")
//    @ApiOperationSupport(order = 9)
//    @ApiOperation(value = "修改密码", notes = "传入密码")
//    public R updatePassword(BladeUser secureUser, @ApiParam(value = "旧密码", required = true) @RequestParam String oldPassword,
//                            @ApiParam(value = "新密码", required = true) @RequestParam String newPassword,
//                            @ApiParam(value = "新密码", required = true) @RequestParam String newPassword1) {
//        boolean temp = userService.updatePassword(secureUser.getUserId(), oldPassword, newPassword, newPassword1);
//        return R.status(temp);
//    }
//
//    /**
//     * 用户列表
//     *
//     * @param secureUser
//     * @return
//     */
//    @GetMapping("/secureUser-list")
//    @ApiOperationSupport(order = 10)
//    @ApiOperation(value = "用户列表", notes = "传入user")
//    public R<List<SecureUser>> userList(SecureUser secureUser) {
//        List<SecureUser> list = userService.list(Condition.getQueryWrapper(secureUser));
//        return R.data(list);
//    }
//
//
//    /**
//     * 导入用户
//     */
//    @PostMapping("import-secureUser")
//    @ApiOperationSupport(order = 12)
//    @ApiOperation(value = "导入用户", notes = "传入excel")
//    public R importUser(MultipartFile file, Integer isCovered) {
//        String filename = file.getOriginalFilename();
//        if (StringUtils.isEmpty(filename)) {
//            throw new RuntimeException("请上传文件!");
//        }
//        if ((!StringUtils.endsWithIgnoreCase(filename, ".xls") && !StringUtils.endsWithIgnoreCase(filename, ".xlsx"))) {
//            throw new RuntimeException("请上传正确的excel文件!");
//        }
//        InputStream inputStream;
//        try {
//            UserImportListener importListener = new UserImportListener(userService);
//            inputStream = new BufferedInputStream(file.getInputStream());
//            ExcelReaderBuilder builder = EasyExcel.read(inputStream, UserExcel.class, importListener);
//            builder.doReadAll();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return R.success("操作成功");
//    }
//
//    /**
//     * 导出用户
//     */
//    @SneakyThrows
//    @GetMapping("export-secureUser")
//    @ApiOperationSupport(order = 13)
//    @ApiOperation(value = "导出用户", notes = "传入user")
//    public void exportUser(@ApiIgnore @RequestParam Map<String, Object> secureUser, BladeUser bladeUser, HttpServletResponse response) {
//        QueryWrapper<SecureUser> queryWrapper = Condition.getQueryWrapper(secureUser, SecureUser.class);
//        if (!SecureUtil.isAdministrator()){
//            queryWrapper.lambda().eq(SecureUser::getTenantId, bladeUser.getTenantId());
//        }
//        queryWrapper.lambda().eq(SecureUser::getIsDeleted, BladeConstant.DB_NOT_DELETED);
//        List<UserExcel> list = userService.exportUser(queryWrapper);
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding(Charsets.UTF_8.name());
//        String fileName = URLEncoder.encode("用户数据导出", Charsets.UTF_8.name());
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), UserExcel.class).sheet("用户数据表").doWrite(list);
//    }
//
//    /**
//     * 导出模板
//     */
//    @SneakyThrows
//    @GetMapping("export-template")
//    @ApiOperationSupport(order = 14)
//    @ApiOperation(value = "导出模板")
//    public void exportUser(HttpServletResponse response) {
//        List<UserExcel> list = new ArrayList<>();
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding(Charsets.UTF_8.name());
//        String fileName = URLEncoder.encode("用户数据模板", Charsets.UTF_8.name());
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), UserExcel.class).sheet("用户数据表").doWrite(list);
//    }
//
//    /**
//     * 第三方注册用户
//     */
//    @PostMapping("/register-guest")
//    @ApiOperationSupport(order = 15)
//    @ApiOperation(value = "第三方注册用户", notes = "传入user")
//    public R registerGuest(SecureUser secureUser, Long oauthId) {
//        return R.status(userService.registerGuest(secureUser, oauthId));
//    }


}
