-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类', '2019', '1', 'clas', 'supplier/clas/index', 1, 0, 'C', '0', '0', 'supplier:clas:list', '#', 'admin', sysdate(), '', null, '供应商分类菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'supplier:clas:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'supplier:clas:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'supplier:clas:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'supplier:clas:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商分类导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'supplier:clas:export',       '#', 'admin', sysdate(), '', null, '');