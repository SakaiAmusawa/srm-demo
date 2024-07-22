-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样', '2125', '1', 'sample_delivery', 'sample/sample_delivery/index', 1, 0, 'C', '0', '0', 'sample:sample_delivery:list', '#', 'admin', sysdate(), '', null, '供应商送样菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'sample:sample_delivery:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'sample:sample_delivery:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'sample:sample_delivery:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'sample:sample_delivery:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商送样导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'sample:sample_delivery:export',       '#', 'admin', sysdate(), '', null, '');