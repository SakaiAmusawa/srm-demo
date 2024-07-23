-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险', '2124', '1', 'risk', 'risk/risk/index', 1, 0, 'C', '0', '0', 'risk:risk:list', '#', 'admin', sysdate(), '', null, '供应商税收违法风险菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'risk:risk:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'risk:risk:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'risk:risk:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'risk:risk:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商税收违法风险导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'risk:risk:export',       '#', 'admin', sysdate(), '', null, '');