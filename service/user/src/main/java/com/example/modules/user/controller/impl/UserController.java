package com.example.modules.user.controller.impl;

import com.example.core.secure.utils.SecureUtil;
import com.example.core.tool.api.R;
import com.example.core.tool.utils.Func;
import com.example.core.tool.utils.RedisUtils;
import com.example.modules.user.controller.vo.UserVO;
import com.example.modules.user.dao.entity.User;
import com.example.modules.user.service.impl.UserService;
import com.example.modules.user.support.UserConvertMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    private final RedisUtils redisUtils;

    /**
     * 查询单条
     */
    @ApiOperationSupport(order = 1)
    @Operation(summary = "查看详情")
    @GetMapping("/detail")
    public R<UserVO> detail(User user) {
        User detail = userService.getOne(user);
        return R.data(UserConvertMapper.INSTANT.from(detail));
    }


    /**
     * 查询挡墙用户信息
     */
    @ApiOperationSupport(order = 2)
    @GetMapping("/info")
    public R<UserVO> info() {
        SecureUtil.User secureUser = SecureUtil.getUser();
        User user = UserConvertMapper.INSTANT.from(secureUser);
        User detail = userService.getById(user.getId());
        return R.data(UserConvertMapper.INSTANT.from(detail));
    }

//    /**
//     * 用户列表
//     */
//    @GetMapping("/list")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "account", value = "账号名", paramType = "query", dataType = "string"),
//            @ApiImplicitParam(name = "realName", value = "姓名", paramType = "query", dataType = "string")
//    })
//    @ApiOperationSupport(order = 3)
//    @ApiOperation(value = "列表", notes = "传入account和realName")
//    public R<IPage<UserVO>> list(@ApiIgnore @RequestParam Map<String, Object> user, Query query, BladeUser bladeUser) {
//        QueryWrapper<User> queryWrapper = Condition.getQueryWrapper(user, User.class);
//        IPage<User> pages = userService.page(Condition.getPage(query), (!bladeUser.getTenantId().equals(BladeConstant.ADMIN_TENANT_ID)) ? queryWrapper.lambda().eq(User::getTenantId, bladeUser.getTenantId()) : queryWrapper);
//        return R.data(UserWrapper.build().pageVO(pages));
//    }
//

    /**
     * 新增或修改
     */
    @PostMapping("/submit")
    @ApiOperationSupport(order = 4)
    public R saveOrUpdate(@Valid @RequestBody User user) {
        return R.status(userService.saveOrUpdate(user));
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperationSupport(order = 5)
    public R update(@Valid @RequestBody User user) {
        return R.status(userService.updateById(user));
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ApiOperationSupport(order = 6)
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
//    public R updatePassword(BladeUser user, @ApiParam(value = "旧密码", required = true) @RequestParam String oldPassword,
//                            @ApiParam(value = "新密码", required = true) @RequestParam String newPassword,
//                            @ApiParam(value = "新密码", required = true) @RequestParam String newPassword1) {
//        boolean temp = userService.updatePassword(user.getUserId(), oldPassword, newPassword, newPassword1);
//        return R.status(temp);
//    }
//
//    /**
//     * 用户列表
//     *
//     * @param user
//     * @return
//     */
//    @GetMapping("/user-list")
//    @ApiOperationSupport(order = 10)
//    @ApiOperation(value = "用户列表", notes = "传入user")
//    public R<List<User>> userList(User user) {
//        List<User> list = userService.list(Condition.getQueryWrapper(user));
//        return R.data(list);
//    }
//
//
//    /**
//     * 导入用户
//     */
//    @PostMapping("import-user")
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
//    @GetMapping("export-user")
//    @ApiOperationSupport(order = 13)
//    @ApiOperation(value = "导出用户", notes = "传入user")
//    public void exportUser(@ApiIgnore @RequestParam Map<String, Object> user, BladeUser bladeUser, HttpServletResponse response) {
//        QueryWrapper<User> queryWrapper = Condition.getQueryWrapper(user, User.class);
//        if (!SecureUtil.isAdministrator()){
//            queryWrapper.lambda().eq(User::getTenantId, bladeUser.getTenantId());
//        }
//        queryWrapper.lambda().eq(User::getIsDeleted, BladeConstant.DB_NOT_DELETED);
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
//    public R registerGuest(User user, Long oauthId) {
//        return R.status(userService.registerGuest(user, oauthId));
//    }


}
