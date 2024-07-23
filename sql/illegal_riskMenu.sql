-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录', '2124', '1', 'illegal_risk', 'illegal_risk/illegal_risk/index', 1, 0, 'C', '0', '0', 'illegal_risk:illegal_risk:list', '#', 'admin', sysdate(), '', null, '供应商非法风险记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'illegal_risk:illegal_risk:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'illegal_risk:illegal_risk:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'illegal_risk:illegal_risk:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'illegal_risk:illegal_risk:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商非法风险记录导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'illegal_risk:illegal_risk:export',       '#', 'admin', sysdate(), '', null, '');