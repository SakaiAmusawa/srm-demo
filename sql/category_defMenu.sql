-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义', '2146', '1', 'category_def', 'category/category_def/index', 1, 0, 'C', '0', '0', 'category:category_def:list', '#', 'admin', sysdate(), '', null, '品类定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'category:category_def:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'category:category_def:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'category:category_def:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'category:category_def:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('品类定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'category:category_def:export',       '#', 'admin', sysdate(), '', null, '');