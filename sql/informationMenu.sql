-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息', '2019', '1', 'information', 'supplier_register/information/index', 1, 0, 'C', '0', '0', 'supplier_register:information:list', '#', 'admin', sysdate(), '', null, '供应商信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'supplier_register:information:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'supplier_register:information:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'supplier_register:information:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'supplier_register:information:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商信息导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'supplier_register:information:export',       '#', 'admin', sysdate(), '', null, '');